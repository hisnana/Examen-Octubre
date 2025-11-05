package GranPremio.ui;

import GranPremio.Caballo;
import GranPremio.Carrera;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarreraFrame extends JFrame {
    private static final int TRACK_MARGIN = 30;
    private static final int TRACK_WIDTH = 620;
    private static final int HORSE_ROW_HEIGHT = 80;
    private static final int ICON_SIZE = 36;

    private final Carrera carrera;
    private final TrackPanel trackPanel;
    private final Map<Caballo, JLabel> caballoLabels;

    public CarreraFrame(Carrera carrera) {
        this.carrera = carrera;
        this.caballoLabels = new LinkedHashMap<>();
        this.trackPanel = new TrackPanel();
        configureFrame();
        buildTrack();
        pack();
        setLocationRelativeTo(null);
    }

    private void configureFrame() {
        setTitle("Carrera: " + carrera.getNombre());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(trackPanel, BorderLayout.CENTER);
        trackPanel.setLayout(null);
        int height = TRACK_MARGIN * 2 + carrera.getCaballosParticipantes().size() * HORSE_ROW_HEIGHT;
        int width = TRACK_MARGIN * 2 + TRACK_WIDTH + 180;
        trackPanel.setPreferredSize(new Dimension(width, height));
    }

    private void buildTrack() {
        int index = 0;
        for (Caballo caballo : carrera.getCaballosParticipantes()) {
            JLabel horseLabel = createHorseLabel(caballo);
            int y = TRACK_MARGIN + index * HORSE_ROW_HEIGHT;
            horseLabel.setBounds(TRACK_MARGIN, y, 180, 48);
            trackPanel.add(horseLabel);
            caballoLabels.put(caballo, horseLabel);
            index++;
        }
    }

    private JLabel createHorseLabel(Caballo caballo) {
        JLabel label = new JLabel(caballo.getNombre(), SwingConstants.LEFT);
        label.setIcon(new ImageIcon(createHorseIcon(caballo)));
        label.setHorizontalTextPosition(SwingConstants.RIGHT);
        label.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        return label;
    }

    private BufferedImage createHorseIcon(Caballo caballo) {
        BufferedImage image = new BufferedImage(ICON_SIZE, ICON_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color baseColor = colorForHorse(caballo);
            g2.setColor(baseColor);
            g2.fillOval(0, 0, ICON_SIZE - 1, ICON_SIZE - 1);
            g2.setColor(baseColor.darker());
            g2.setStroke(new BasicStroke(2f));
            g2.drawOval(1, 1, ICON_SIZE - 3, ICON_SIZE - 3);
            String initial = caballo.getNombre().isEmpty() ? "" : caballo.getNombre().substring(0, 1).toUpperCase();
            g2.setColor(Color.WHITE);
            Font font = trackPanel.getFont().deriveFont(Font.BOLD, 18f);
            g2.setFont(font);
            FontMetrics metrics = g2.getFontMetrics();
            int textX = (ICON_SIZE - metrics.stringWidth(initial)) / 2;
            int textY = (ICON_SIZE - metrics.getHeight()) / 2 + metrics.getAscent();
            g2.drawString(initial, textX, textY);
        } finally {
            g2.dispose();
        }
        return image;
    }

    private Color colorForHorse(Caballo caballo) {
        int hash = Math.abs(caballo.getNombre().hashCode());
        float hue = (hash % 360) / 360f;
        return Color.getHSBColor(hue, 0.6f, 0.9f);
    }

    public void showFrame() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    public void updateProgress() {
        SwingUtilities.invokeLater(() -> {
            for (Map.Entry<Caballo, JLabel> entry : caballoLabels.entrySet()) {
                Caballo caballo = entry.getKey();
                JLabel label = entry.getValue();
                double ratio = carrera.getDistanciaObjetivo() == 0 ? 0
                        : Math.min(1.0, (double) caballo.getMetrosRecorridos() / carrera.getDistanciaObjetivo());
                int x = TRACK_MARGIN + (int) (ratio * TRACK_WIDTH);
                label.setLocation(x, label.getY());
                label.setText(String.format("%s (%dm)", caballo.getNombre(), caballo.getMetrosRecorridos()));
            }
            trackPanel.repaint();
        });
    }

    public void showWinner(Caballo caballo) {
        SwingUtilities.invokeLater(() -> {
            JLabel label = caballoLabels.get(caballo);
            if (label != null) {
                label.setBorder(BorderFactory.createLineBorder(new Color(0x388E3C), 3, true));
            }
        });
    }

    private class TrackPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            try {
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int finishX = TRACK_MARGIN + TRACK_WIDTH;
                g2.setColor(new Color(220, 220, 220));
                for (int i = 0; i < carrera.getCaballosParticipantes().size(); i++) {
                    int y = TRACK_MARGIN + i * HORSE_ROW_HEIGHT + HORSE_ROW_HEIGHT / 2 + 12;
                    g2.fillRoundRect(TRACK_MARGIN - 10, y - 12, TRACK_WIDTH + 20, 6, 6, 6);
                }
                g2.setColor(new Color(0xD32F2F));
                g2.setStroke(new BasicStroke(3f));
                g2.drawLine(finishX, TRACK_MARGIN / 2, finishX, getHeight() - TRACK_MARGIN / 2);
            } finally {
                g2.dispose();
            }
        }
    }
}

package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainPage extends JFrame {

  Graphics g;
  String State = null;
  int lx, ly;
  int scaleX, scaleY;
  Color currentFillColor = null;

  private int rotationAngle = 0;

  MainPage() {
    initComponents();
    addComponents();
    locateComponents();

    g = panel.getGraphics();
    panel.paintComponents(g);
  }

  private void initComponents() {
    setVisible(true);
    setTitle("Projek Akhir Grafika Komputer (720x680)");
    setSize(750, 966);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null);

    btnClear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnClearHandler(e);
      }
    });
    btnRectangle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnRectangleHandler(e);
      }
    });
    btnOval.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnOvalHandler(e);
      }
    });
    btnTriangle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnTriangleHandler(e);
      }
    });
    btnPentagon.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnPentagonHandler(e);
      }
    });
    btnHexagon.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnHexagonHandler(e);
      }
    });
    btnRed.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnColorHandler(e, Color.red);
      }
    });
    btnGreen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnColorHandler(e, Color.green);
      }
    });
    btnBlue.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnColorHandler(e, Color.blue);
      }
    });
    btnTranslate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnTranslateHandler(e);
      }
    });
    btnScale.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnScaleHandler(e);
      }
    });
    btnRotate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnRotateHandler(e);
      }
    });
  }

  private void addComponents() {
    add(panel);

    add(btnClear);
    add(btnTranslate);
    add(btnRotate);
    add(btnScale);

    add(btnRectangle);
    add(btnOval);
    add(btnTriangle);
//    add(btnPentagon);
//    add(btnHexagon);

    add(btnRed);
    add(btnGreen);
    add(btnBlue);

    add(inputTranslateX);
    add(inputTranslateY);
    add(inputScaleX);
    add(inputScaleY);
    add(inputRotate);

    add(labelTitle);
    add(labelShape);
    add(labelFillColor);

    add(labelTranslate);
    add(labelInputTranslateX);
    add(labelInputTranslateY);

    add(labelScale);
    add(labelInputScaleX);
    add(labelInputScaleY);

    add(labelInputRotate);
  }

  private void locateComponents() {
    labelShape.setBounds(20, 8, 240, 20);
    btnRectangle.setBounds(20, 32, 128, 28);
    btnOval.setBounds(154, 32, 128, 28);
    btnTriangle.setBounds(288, 32, 128, 28);
    btnPentagon.setBounds(422, 32, 128, 28);
    btnHexagon.setBounds(556, 32, 128, 28);

    labelFillColor.setBounds(20, 70, 240, 20);
    btnRed.setBounds(20, 94, 96, 28);
    btnGreen.setBounds(122, 94, 96, 28);
    btnBlue.setBounds(224, 94, 96, 28);

    labelTranslate.setBounds(20, 132, 240, 20);
    labelInputTranslateX.setBounds(40, 156, 24, 28);
    inputTranslateX.setBounds(68, 156, 44, 28);
    labelInputTranslateY.setBounds(124, 156, 24, 28);
    inputTranslateY.setBounds(152, 156, 44, 28);
    btnTranslate.setBounds(208, 156, 96, 28);

    labelScale.setBounds(340, 132, 240, 20);
    labelInputScaleX.setBounds(360, 156, 24, 28);
    inputScaleX.setBounds(388, 156, 44, 28);
    labelInputScaleY.setBounds(444, 156, 24, 28);
    inputScaleY.setBounds(472, 156, 44, 28);
    btnScale.setBounds(528, 156, 96, 28);

    labelInputRotate.setBounds(20, 194, 44, 28);
    inputRotate.setBounds(68, 194, 128, 28);
    btnRotate.setBounds(208, 194, 96, 28);

    btnClear.setBounds(340, 194, 284, 28);
    panel.setBackground(new java.awt.Color(255, 255, 255));
    panel.setBounds(8, 240, 720, 680);
  }

  private void btnRectangleHandler(ActionEvent event) {
    setPanelBlank();
    resetRotation();
    resetColor();
    lx = panel.getWidth() / 2 - 200 / 2;
    ly = panel.getHeight() / 2 - 120 / 2;
    g.drawRect(lx, ly, 200, 120);
    State = "Rectangle";
  }

  private void btnOvalHandler(java.awt.event.ActionEvent event) {
    setPanelBlank();
    resetRotation();
    resetColor();
    lx = panel.getWidth() / 2 - 200 / 2;
    ly = panel.getHeight() / 2 - 120 / 2;
    g.drawOval(lx, ly, 200, 120);
    State = "Oval";
  }

  private void btnTriangleHandler(java.awt.event.ActionEvent event) {
    setPanelBlank();
    resetRotation();
    resetColor();
    lx = panel.getWidth() / 2 - 200 / 2;
    ly = panel.getHeight() / 2 - 120 / 2;
    int x[] = {lx, lx + 100, lx + 200};
    int y[] = {ly + 120, ly, ly + 120};
    g.drawPolygon(x, y, 3);
    State = "Triangle";
  }

  private void btnPentagonHandler(ActionEvent event) {
    setPanelBlank();
    lx = panel.getWidth() / 2 - 200 / 2;
    ly = panel.getHeight() / 2 - 120 / 2;
    System.out.println(ly);
    int x[] = {lx, lx + 100, lx + 200, lx + 300, lx + 400};
    int y[] = {ly + 120, ly, ly + 120, ly, ly + 120};
    g.drawPolygon(x, y, 5);
    State = "Pentagon";
  }

  private void btnHexagonHandler(java.awt.event.ActionEvent event) {
    setPanelBlank();
    lx = panel.getWidth() / 2 - 120 / 2;
    ly = panel.getHeight() / 2 - 120 / 2;
    g.drawRect(lx, ly, 120, 120);
    State = "Hexagon";
  }

  private void btnColorHandler(ActionEvent event, Color color) {
    if (State != null) {
      setPanelBlank();
      g.setColor(color);
      currentFillColor = color;

      switch (State) {
        case "Rectangle": {
          createRectangle();
          break;
        }
        case "Oval": {
          createOval();
          break;
        }
        case "Triangle": {
          createTriangle();
          break;
        }
        default:
          break;
      }
    } else {
      JOptionPane.showMessageDialog(null, "Tidak ada bangun datar.");
    }
  }

  private void btnTranslateHandler(ActionEvent event) {
    try {
      if (State == null) {
        throw new Exception("Tidak ada bangun datar yang dipilih");
      }
      String inputX = inputTranslateX.getText();
      String inputY = inputTranslateY.getText();
      if ("".equals(inputX) || "".equals(inputY)) {
        throw new Exception("Input masih kosong");
      }

      int tx = Integer.parseInt(inputTranslateX.getText());
      int ty = Integer.parseInt(inputTranslateY.getText());
      lx += tx;
      ly += ty;

      setPanelBlank();
      switch (State) {
        case "Rectangle":
          createRectangle();
          break;
        case "Oval":
          createOval();
          break;
        case "Triangle":
          createTriangle();
          break;
        default:
          break;
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
    }
  }

  private void btnRotateHandler(ActionEvent event) {
    try {
      if (State == null) {
        throw new Exception("Tidak ada bangun datar yang dipilih");
      }
      String inputAngle = inputRotate.getText();
      if ("".equals(inputAngle)) {
        throw new Exception("Input masih kosong");
      }

      int angle = Integer.parseInt(inputAngle);
      rotationAngle += angle;
      setPanelBlank();
      switch (State) {
        case "Rectangle":
          createRectangle();
          break;
        case "Oval":
          createOval();
          break;
        case "Triangle":
          createTriangle();
          break;
        default:
          break;
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
    }
  }

  private void btnScaleHandler(ActionEvent event) {
    System.out.println("Tes");
  }

  private void btnClearHandler(ActionEvent event) {
    panel.repaint();
    g.setColor(Color.BLACK);
    State = null;
  }

  void setPanelBlank() {
    g.setColor(Color.WHITE); // Set the fill color to white
    g.fillRect(0, 0, panel.getWidth(), panel.getHeight()); // Clear the canvas
    g.setColor(Color.BLACK); // Set outline color to black
  }

  void resetRotation() {
    rotationAngle = 0;
  }

  void resetColor() {
    currentFillColor = null;
  }

  void createRectangle() {
    Graphics2D graphics2D = (Graphics2D) g.create();
    int width = 200;
    int height = 120;

    // Menghitung titik pusat
    int centroidX = lx + (width / 2);
    int centroidY = ly + (height / 2);

    graphics2D.translate(centroidX, centroidY);
    graphics2D.rotate(Math.toRadians(rotationAngle));
    if (currentFillColor == null) {
      graphics2D.drawRect(-width / 2, -height / 2, width, height);
    } else {
      graphics2D.setColor(currentFillColor);
      graphics2D.fillRect(-width / 2, -height / 2, width, height);
    }
  }

  void createOval() {
    Graphics2D graphics2D = (Graphics2D) g.create();
    int width = 200;
    int height = 120;

    // Menghitung titik pusat
    int centroidX = lx + (width / 2);
    int centroidY = ly + (height / 2);

    graphics2D.translate(centroidX, centroidY);
    graphics2D.rotate(Math.toRadians(rotationAngle));
    if (currentFillColor == null) {
      graphics2D.drawOval(-width / 2, -height / 2, width, height);
    } else {
      graphics2D.setColor(currentFillColor);
      graphics2D.fillOval(-width / 2, -height / 2, width, height);
    }
  }

  void createTriangle() {
    Graphics2D graphics2D = (Graphics2D) g.create();
    int x[] = {lx, lx + 100, lx + 200};
    int y[] = {ly + 120, ly, ly + 120};

    // Calculate the centroid of the triangle
    int centroidX = (x[0] + x[1] + x[2]) / 3;
    int centroidY = (y[0] + y[1] + y[2]) / 3;

    // Rotate around the centroid
    graphics2D.rotate(Math.toRadians(rotationAngle), centroidX, centroidY);
    if (currentFillColor == null) {
      graphics2D.drawPolygon(x, y, 3);
    } else {
      graphics2D.fillPolygon(x, y, 3);
    }
  }

  private JPanel panel = new JPanel();
  private JButton btnClear = new JButton("Clear"), btnTranslate = new JButton("Translate"), btnRotate = new JButton("Rotate"), btnScale = new JButton("Scale");
  private JButton btnPentagon = new JButton("Pentagon"), btnRectangle = new JButton("Rectangle"), btnOval = new JButton("Oval"), btnTriangle = new JButton("Triangle"), btnHexagon = new JButton("Hexagon");
  private JButton btnRed = new JButton("Red"), btnGreen = new JButton("Green"), btnBlue = new JButton("Blue");

  private final JTextField inputTranslateX = new JTextField();
  private final JTextField inputTranslateY = new JTextField();
  private final JTextField inputScaleX = new JTextField();
  private final JTextField inputScaleY = new JTextField();
  private final JTextField inputRotate = new JTextField();

  private final JLabel labelTitle = new JLabel("Grafika Komputer");
  private final JLabel labelShape = new JLabel("Shape");
  private final JLabel labelFillColor = new JLabel("Fill Color");

  private final JLabel labelScale = new JLabel("Scale (X, Y)");
  private final JLabel labelInputScaleX = new JLabel("X = ");
  private final JLabel labelInputScaleY = new JLabel("Y = ");

  private final JLabel labelTranslate = new JLabel("Translate (X, Y)");
  private final JLabel labelInputTranslateX = new JLabel("X = ");
  private final JLabel labelInputTranslateY = new JLabel("Y = ");

  private final JLabel labelInputRotate = new JLabel("Rotate");
}

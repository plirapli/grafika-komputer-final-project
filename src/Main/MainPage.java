package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainPage extends JFrame {

  private Graphics g;
  private String State = null;
  private int lx, ly, width, height;
  private Color currentFillColor = null;
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

    // Shape
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

    // Color
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

    // Manipulation
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
    btnClear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnClearHandler(e);
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
    add(btnPentagon);
    add(btnHexagon);

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
    resetCanvas();
    resetAll();
    createRectangle();
    State = "Rectangle";
  }

  private void btnOvalHandler(java.awt.event.ActionEvent event) {
    resetCanvas();
    resetAll();
    createOval();
    State = "Oval";
  }

  private void btnTriangleHandler(java.awt.event.ActionEvent event) {
    resetCanvas();
    resetAll();
    createTriangle();
    State = "Triangle";
  }

  private void btnPentagonHandler(ActionEvent event) {
    resetCanvas();
    resetAll();
    createPentagon();
    State = "Pentagon";
  }

  private void btnHexagonHandler(java.awt.event.ActionEvent event) {
    resetCanvas();
    resetAll();
    createHexagon();
    State = "Hexagon";
  }

  private void btnColorHandler(ActionEvent event, Color color) {
    if (State != null) {
      resetCanvas();
      g.setColor(color);
      currentFillColor = color;
      createShape();
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

      int tx = Integer.parseInt(inputX);
      int ty = Integer.parseInt(inputY);
      lx += tx;
      ly += ty;
      resetCanvas();
      createShape();
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
      resetCanvas();
      createShape();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
    }
  }

  private void btnScaleHandler(ActionEvent event) {
    try {
      if (State == null) {
        throw new Exception("Tidak ada bangun datar yang dipilih");
      }
      String inputX = inputScaleX.getText();
      String inputY = inputScaleY.getText();
      if ("".equals(inputX) || "".equals(inputY)) {
        throw new Exception("Input masih kosong");
      }

      int scaleX = Integer.parseInt(inputX);
      int scaleY = Integer.parseInt(inputY);
      width += scaleX;
      height += scaleY;
      resetCanvas();
      createShape();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
    }
  }

  private void btnClearHandler(ActionEvent event) {
    panel.repaint();
    g.setColor(Color.BLACK);
    State = null;
  }

  void createShape() {
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
      case "Pentagon":
        createPentagon();
        break;
      case "Hexagon":
        createHexagon();
        break;
      default:
        break;
    }
  }

  void createRectangle() {
    Graphics2D graphics2D = (Graphics2D) g.create();

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
    int x[] = {lx, lx + width / 2, lx + width};
    int y[] = {ly + height, ly, ly + height};

    // Calculate the centroid of the triangle
    int centroidX = (x[0] + x[1] + x[2]) / 3;
    int centroidY = (y[0] + y[1] + y[2]) / 3;
    System.out.println(centroidX + ", " + centroidY);

    // Rotate around the centroid
    graphics2D.rotate(Math.toRadians(rotationAngle), centroidX, centroidY);
    if (currentFillColor == null) {
      graphics2D.drawPolygon(x, y, x.length);
    } else {
      graphics2D.setColor(currentFillColor);
      graphics2D.fillPolygon(x, y, x.length);
    }
  }

  void createPentagon() {
    Graphics2D graphics2D = (Graphics2D) g.create();

    /*
    Set the coordinate:
    
            5
    1             4
         2   3
    
     */
    int yTengah = ly + (height / 2) - (height / 8);
    int x[] = {lx, lx + (width / 8), lx + width - (width / 8), lx + width, lx + (width / 2)};
    int y[] = {yTengah, ly + height, ly + height, yTengah, ly};

    // Calculate the centroid of the triangle
    int centroidX = (x[0] + x[1] + x[2] + x[3] + x[4]) / 5;
    int centroidY = (y[0] + y[1] + y[2] + y[3] + y[4]) / 5;

    // Rotate around the centroid
    graphics2D.rotate(Math.toRadians(rotationAngle), centroidX, centroidY);
    if (currentFillColor == null) {
      graphics2D.drawPolygon(x, y, x.length);
    } else {
      graphics2D.setColor(currentFillColor);
      graphics2D.fillPolygon(x, y, x.length);
    }
  }

  void createHexagon() {
    Graphics2D graphics2D = (Graphics2D) g.create();

    /*
    Set the coordinate:
    
         6   5
    1             4
         2   3
    
     */
    int yTengah = ly + height / 2;
    int xTengah1 = lx + (width / 4);
    int xTengah2 = lx + width - (width / 4);
    int x[] = {lx, xTengah1, xTengah2, lx + width, xTengah2, xTengah1};
    int y[] = {yTengah, ly + height, ly + height, yTengah, ly, ly};

    // Calculate the centroid of the triangle
    int centroidX = (x[0] + x[1] + x[2] + x[3] + x[4] + x[5]) / 6;
    int centroidY = (y[0] + y[1] + y[2] + y[3] + y[4] + x[5]) / 6;

    // Rotate around the centroid
    graphics2D.rotate(Math.toRadians(rotationAngle), centroidX, centroidY);
    if (currentFillColor == null) {
      graphics2D.drawPolygon(x, y, x.length);
    } else {
      graphics2D.setColor(currentFillColor);
      graphics2D.fillPolygon(x, y, x.length);
    }
  }

  void resetCanvas() {
    g.setColor(Color.WHITE); // Set the fill color to white
    g.fillRect(0, 0, panel.getWidth(), panel.getHeight()); // Clear the canvas
    g.setColor(Color.BLACK); // Set outline color to black
  }
  void resetAll() {
    resetColor();
    resetCoordinate();
    resetRotation();
    resetRotation();
    resetSize();
  }
  void resetColor() {
    currentFillColor = null;
  }
  void resetCoordinate() {
    lx = panel.getWidth() / 2 - 200 / 2;
    ly = panel.getHeight() / 2 - 120 / 2;
  }
  void resetRotation() {
    rotationAngle = 0;
  }
  void resetSize() {
    width = 144;
    height = 144;
  }

  private final JPanel panel = new JPanel();
  private final JButton btnClear = new JButton("Clear");
  private final JButton btnTranslate = new JButton("Translate");
  private final JButton btnRotate = new JButton("Rotate");
  private final JButton btnScale = new JButton("Scale");
  private final JButton btnPentagon = new JButton("Pentagon");
  private final JButton btnRectangle = new JButton("Rectangle");
  private final JButton btnOval = new JButton("Oval");
  private final JButton btnTriangle = new JButton("Triangle");
  private final JButton btnHexagon = new JButton("Hexagon");
  private final JButton btnRed = new JButton("Red");
  private final JButton btnGreen = new JButton("Green");
  private final JButton btnBlue = new JButton("Blue");

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

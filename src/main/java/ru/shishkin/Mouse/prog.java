// Для работы с окнами
import javax.swing.*;
//Для работы с графикой
import java.awt.*;
//Для работы с обработчиками событий
import java.awt.event.*;

//Главный класс программы
public class prog {

	// Главный метод, который запускает программу
	public static void main(String[] args) {

		// Создание объекта окна
		okno window = new okno();

	}
}

// Класс окна
class okno extends JFrame {

	// Конструктор класса окна
	public okno() {
		// Задание размеров и положения окна
		setBounds(0, 0, 800, 600);
		// Задание заголовка окна
		setTitle("Работа с мышью");

		// Устанавливаем окончание работы приложения
		// при закрытии окна
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Запрет изменения размеров окна
		setResizable(false);

		// Создание объекта панели
		panel pan = new panel();

		// Получение содержимого (контента) окна
		Container con = getContentPane();
		// Прикрепление (вложение) панели в окно
		con.add(pan);

		// Сделать окно видимым
		setVisible(true);
	}
}

// Класс панели, которая вложена в окно
class panel extends JPanel {
	// Массив цветов
	Color[] masColor;
	
	JButton btn;
	JTextField txt;

	// Переменная - отвечающая
	// за текущий выбранный цвет
	int tCol = 0;

	// Переменные для хранения
	// координат мыши
	int mX, mY, mX0, mY0;

	// Переменная - признак того,
	// что пользователь рисует
	Boolean flag = false;

	public class myMouse1 implements MouseListener {

		// Щелчок кнопкой мыши
		public void mouseClicked(MouseEvent e) {

		}

		// Нажатие кнопки мыши
		public void mousePressed(MouseEvent e) {
			// Получаем координаты мыши
			int tX = e.getX();
			int tY = e.getY();

			// Получаем количество нажатий клавиши
			int col = e.getClickCount();

			// Получаем номер нажатой клавиши - 1, 2 или 3
			int btn = e.getButton();

			// Проверяем, что сейчас курсор находится в области выбора цвета
			if ((tX > 0) && (tX < 800) && (tY > 0) && (tY < 50)) {
				// Проверяем, что клавиша была нажата один раз
				if (col == 1) {
					// Проверяем, что была нажата левая клавиша
					if (btn == 1) {
						// По координате X курсора мыши вычисляем номер цвета
						// при делении дробная часть будет отбрасываться
						// потому что переменная tCol целого типа
						tCol = tX / 100;
					}
				}
			}
						// Если кусор в той части, где можно рисовать
						if (tY > 50) {
							// Запоминаем координаты мыши в переменных
							mX0 = tX;
							mY0 = tY;

							// Признак, что пользователь рисует
							flag = true;


						}
			
		}

		// При отпускании кнопки мыши после нажатия
		public void mouseReleased(MouseEvent e) {
			// Признак рисования делаем ЛОЖЬ - пользователь не рисует
			flag = false;
		}

		// При появлении курсора мыши на панели окна
		public void mouseEntered(MouseEvent e) {

		}

		// При выходе курсора мыши за пределы панели окна
		public void mouseExited(MouseEvent e) {

		}
	}

	public class myMouse2 implements MouseMotionListener {
		// При перемещение мыши с нажатой кнопкой - захват
		public void mouseDragged(MouseEvent e) {
			// Получение координат курсора мыши
			int tX = e.getX();
			int tY = e.getY();

			// Если кусор в той части, где можно рисовать
			if (tY > 50) {
				// Запоминаем координаты мыши в переменных
				mX = tX;
				mY = tY;


				// Признак, что пользователь рисует
				flag = true;

				// Вызов метода public void paintComponent(Graphics gr)
				repaint();
			}
		}

		// При перемещение мыши
		public void mouseMoved(MouseEvent e) {
			// Получение координат курсора мыши
			int tX = e.getX();
			int tY = e.getY();

			// Проверка, что курсор находится в области выбора цветов
			if ((tX > 0) && (tX < 800) && (tY > 0) && (tY < 50)) {
				// Установка курсора ввиде пальца
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else {
				// Установка обычного курсора ввиде стрелочки
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}

	// Конструктор класса панели
	public panel() {
		
		setLayout(null);
		
		btn = new JButton("OK");
		btn.setForeground(Color.BLUE);
		btn.setBounds(300,400,100,50);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = txt.getText();
				JOptionPane.showMessageDialog(null, "Hello!");
				
			}
		});
		add(btn);
		
		txt = new JTextField();
		txt.setBackground(Color.CYAN);
		txt.setFont(new Font("arial",0,40));
		txt.setBounds(50,200,400,100);
		add(txt);
		
		// Подключаем обработчики для мыши к нашей панели окна
		addMouseListener(new myMouse1());
		addMouseMotionListener(new myMouse2());

		// Делаем окно активным
		setFocusable(true);

		// Создаем массив из семи элементов
		masColor = new Color[8];
		// Заполняем массив цветами
		masColor[0] = Color.BLACK;
		masColor[1] = Color.GREEN;
		masColor[2] = Color.BLUE;
		masColor[3] = Color.RED;
		masColor[4] = Color.YELLOW;
		masColor[5] = Color.WHITE;
		masColor[6] = Color.ORANGE;
		masColor[7] = Color.CYAN;

	}

	// Метод, который отрисовывает графические объекты на панели
	public void paintComponent(Graphics gr) {
		// Рисуем семь прямоугольников
		// в верхней части для выбора цвета
		for (int i = 0; i < 8; i++) {
			// Устанавливаем цвет рисования
			gr.setColor(masColor[i]);
			// Рисуем закрашенный прямоугольник
			gr.fillRect(i * 100, 0, 100, 50);
		}

		// Если признак рисования ИСТИНА - рисуем
		// маленький квадрат выбранным цветом
		// в точке где находится курсор мыши
		if (flag == true) {
			// Устанавливаем цвет рисования
			gr.setColor(masColor[tCol]);

			// Рисуем закрашенный маленький квадрат
			//gr.fillRect(mX, mY, 3, 3);

			gr.drawLine(mX0, mY0, mX, mY);
			mX0=mX;
			mY0=mY;
		}
	}
}

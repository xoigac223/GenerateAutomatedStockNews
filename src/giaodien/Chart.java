package giaodien;

import java.util.Calendar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import readfile.ReadFiles;
import stockmarket.BigStock;

public class Chart extends Application{
	private static BigStock stock,stock1,stock2;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Ngày");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Điểm");
		// Tạo đối tượng lineChart 
		LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
	    XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
	    XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
	    XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<String, Number>();
	    Calendar calendar0 = Calendar.getInstance();
	    calendar0.setTime(stock.getDate());
	    int year = calendar0.get(Calendar.YEAR);
	    dataSeries.setName(year+"");
	    if(stock1!=null) {
	    	calendar0.setTime(stock1.getDate());
	    	int year1 = calendar0.get(Calendar.YEAR);
	    	dataSeries1.setName(year1+"");
	    }
	    if(stock2!=null) {
	    	calendar0.setTime(stock2.getDate());
	    	int year1 = calendar0.get(Calendar.YEAR);
	    	dataSeries2.setName(year1+"");
	    }
	    for(int i=100; i>=0;i--) {
	    	Calendar calendar = Calendar.getInstance();
	    	while(stock.history(-i)==null)
	    		i--;
	    	calendar.setTime(stock.history(-i).getDate());
	    	double point = stock.history(-i).getGiaDongCua();
	    	String date = calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1);
	    	dataSeries.getData().add(new XYChart.Data<String, Number>(date,point));
	    	if(stock1!=null) {
	    		int j = i;
	    		while(stock1.history(-j)==null)
	    			j--;
	    		double point1 = stock1.history(-j).getGiaDongCua();
		    	dataSeries1.getData().add(new XYChart.Data<String, Number>(date,point1));
	    	}
	    	if(stock2!=null) {
	    		int j = i;
	    		while(stock2.history(-j)==null)
	    			j--;
	    		double point2 = stock2.history(-j).getGiaDongCua();
		    	dataSeries2.getData().add(new XYChart.Data<String, Number>(date,point2));
	    	}
	       }
	       // Thêm Series vào lineChart
	    lineChart.getData().add(dataSeries);
	    if(stock1!=null)
	    	lineChart.getData().add(dataSeries1);;
	    if(stock2!=null)
	    	lineChart.getData().add(dataSeries2);;
	    lineChart.setTitle("Biểu đồ " + stock.getSymbol() + " đến hôm nay.");
	    lineChart.setSnapToPixel(true);
	       
	    VBox vbox = new VBox(lineChart);
	    primaryStage.setTitle("JavaFX LineChart");
	    Scene scene = new Scene(vbox, 900, 900);
	    primaryStage.setScene(scene);
	    primaryStage.setHeight(500);
	    primaryStage.setWidth(900);
	    primaryStage.show();   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stock = new BigStock(new ReadFiles(args[0]));
		if(args[1]!=null)
			stock1 = new BigStock(new ReadFiles(args[1]));
		if(args[2]!=null)
			stock2 = new BigStock(new ReadFiles(args[2]));
		Application.launch();

	}

}

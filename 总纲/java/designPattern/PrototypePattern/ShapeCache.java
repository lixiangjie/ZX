package PrototypePattern;

import java.util.Hashtable;

//创建一个类ShapeCache，从数据库获取实体类，并把它们存储在一个 Hashtable 中。
public class ShapeCache {
	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();
	public static Shape getShape(String shapeId){
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}
	
	//对每种形状都运行数据库查询，并创建该形状
	//shapeMap.put(shapeKey, shape);
	//添加三种图形
	public static void loadCache(){
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);
		
		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}







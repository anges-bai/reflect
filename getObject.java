public static Object getObject(Object obj,String attribute) throws Exception{ 
String methodName = "get" + initCap(attribute) ; 
// 调用指定属性的Field对象，目的是取得对象类型，如果没有此属性意味着操作无法继续进行 
Field field = obj.getClass().getDeclaredField(attribute) ;
if (field == null) {
// 第二次尝试从父类中取得该属性 
field = obj.getClass().getField(attribute) ;
}
if (field == null) { 
// 两次都未取得指定属性的对象，表示该对象一定不存在
return null ;
}
Method method = obj.getClass().getMethod(methodName) ; 
// 调用getter方法取得实例化对象 
Object objectInstance = method.invoke(obj) ;
if (objectInstance==null) { 
// 现在没有实例化关联类对象，必须自己手工实例化关联类对象
// 所有程序类都可以根据反射来取得实例化对象,只需要取得类的Class类型
// 实例化新对象 
objectInstance = field.getType().newInstance() ; 
setObjectValue(obj,attribute,objectInstance);

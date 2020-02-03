
/** * 负责设置类中的属性操作 
* @param actionObject 表示当前发出设置请求的程序类的当前对象 
* @param msg 属性的具体内容，格式为:"属性名称:|内容|属性名称:|内容..."
*/

public static void setBeanValue(Object actionObject,String msg) throws Exception{ 
// 要想进行内容的设置，必须将字符串拆分 
// 按照竖线拆分，取出所有要设置的内容 
String[] result = msg.split("\\|") ;
// 每次执行后只剩下"属性名称:内容" 
for (int i = 0; i < result.length ; i++) {
// 需要针对属性名称及内容做进一步拆分 
String[] temp = result[i].split(":") ;
// 属性名称 "emp.ename" 
String attribute = temp[0] ;
// 属性内容 String value = temp[1] ;
// 通过属性的拆分就可以区分出是单级VO还是多级 
String[] fields = attribute.split("\\.") ; 
if (fields.length > 2 ) {
// 多级VO操作
// 如果要想通过多级确定出属性的操作对象，那么就应该一层层找出每一个getter方法返回的 内容 
Object currentObject = actionObject ; 
// 确定当前操作的对象 
for(int x = 0 ; x < fields.length-1 ; x++ ){ 
// 对应getter的返回对象
// 循环结束一定能拿到最后一层的当前对象 
currentObject = getObject(currentObject,fields[x]) ;
}

setObjectValue(currentObject,fields[fields.length - 1],value) ;
}
else {
// 单级VO
// 获取当前操作的简单Java类对象 
Object currentObject = getObject(actionObject,fields[0]) ; 
// 调用简单Java类的setter方法 
setObjectValue(currentObject,fields[1],temp[1]); 
}
}
}

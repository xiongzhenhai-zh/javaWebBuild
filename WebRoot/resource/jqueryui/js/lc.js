var lc = new Object()
lc.ns = {};
lc.data = {};
lc.initNs = function(str){
	if(str&&!lc.ns[str]){
		lc.ns[str] = {};
	}
}
function paramString2obj (serializedParams) {
    var obj={};
    function evalThem (str) {
        var attributeName = str.split("=")[0];
        var attributeValue = str.split("=")[1];
        if(!attributeValue){
            return ;
        }
        var array = attributeName.split(".");
        for (var i = 1; i < array.length; i++) {
            var tmpArray = Array();
            tmpArray.push("obj");
            for (var j = 0; j < i; j++) {
                tmpArray.push(array[j]);
            };
            var evalString = tmpArray.join(".");
            // alert(evalString);
            if(!eval(evalString)){
                eval(evalString+"={};");                
            }
        };
        eval("obj."+attributeName+"='"+attributeValue+"';");
    };
    var properties = serializedParams.split("&");
    for (var i = 0; i < properties.length; i++) {
        evalThem(properties[i]);
    };
    return obj;
} 
$.fn.formToObject = function(){
    var serializedParams = this.serialize();
    serializedParams = decodeURIComponent(serializedParams,true)
    var obj = paramString2obj(serializedParams);
    return obj;
}
lc.formatTreeData = function(list,formatField){
	var array = new Array();
	for(var i=0;i<list.length;i++){
		var data = {};
		data.id = list[i].id;
		data.text = list[i].name;
		data.iconCls 	= (list[i].icon==null)?"icon-item":"icon-"+list[i].icon;
		if(data.parent){
			data.parent = {};
			data.parent.id 	= list[i].parent.id;
		}
		if(formatField){
			data = formatField(data,list[i])
		}
		if(list[i].children&&list[i].children.length>0){
			data.children = lc.formatTreeData(list[i].children,formatField);
		}
		array[array.length] = data;
	}
	return array;
};
lc.nav = function(page){
	$.get("page/nav/"+page,function(data){
		$("#lc_nav").html(data);
		$.parser.parse("#lc_nav");
	})
}
lc.subnav = function(page){
	$.get("page/"+page,function(data){
		$("#lc_main").html(data);
		$.parser.parse("#lc_main");
		lc.currPageInit();
	})
}
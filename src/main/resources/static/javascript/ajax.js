$(function(){
    $("#selection_p").change(function(){
        var value = $("#selection_p option:selected").val();
        $.get("skilllist/" + value ,function(data){
            var obj = $.parseJSON(data);
            console.debug(obj[0].itemValue)
            $("#selection_c").html("");
            for(var i=0;i<obj.length;i++){
                $("#selection_c").append("<option value="+obj[i].itemValue+">"+obj[i].itemLabel+"</option>");
            }
        })
    })
})
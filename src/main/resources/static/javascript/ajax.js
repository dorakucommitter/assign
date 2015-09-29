$(function(){
    $("#selectionField").change(function(){
        var value = $("#selectionField option:selected").val();
        console.debug(value.length);
        if (value.length === 0) {
        	$("#selectionSkill").html("");
        	return;
        }
        $.get("skilllist/" + value ,function(data){
            var obj = $.parseJSON(data);
            $("#selectionSkill").html("");
            $("#selectionSkill").append("<option></option>");
            for(var i=0;i<obj.length;i++){
                $("#selectionSkill").append("<option value="+obj[i].itemValue+">"+obj[i].itemLabel+"</option>");
            }
        })
    })
});

$(function() {
    $("#buttonSkillSearch").click(function() {


        var param1 = $("#selectionField").val();
        var param2 = $("#selectionSkill").val();
        var param3 = $("#inputEmployeeName").val();
        var data = {field: param1, skill: param2, name: param3 };
        $("#tableSkill").html("");
        $("#tableSkill").append("<thead><tr><th>氏名</th><th>スキル</th><th>経験年数</th></tr></thead>");

        $.ajax({
            type:"post",
            url:"skilltable",
            data:JSON.stringify(data),
            contentType: 'application/json',
            dataType: "json",
            success: function(json_data) {
                // 成功時の処理
                for(var i=0;i<json_data.length;i++){

                    $("#tableSkill").append(
                    		$("<tr></tr>")
    			                .append($("<td></td>").text(json_data[i].itemName))
    			                .append($("<td></td>").text(json_data[i].itemSkill))
    			                .append($("<td></td>").text(json_data[i].itemExperience))
                    		);
                }
            }

        });


    });

});
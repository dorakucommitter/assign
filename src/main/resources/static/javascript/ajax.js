$(function(){
    $("#selectionField").change(function(){
        var value = $("#selectionField option:selected").val();
        $.get("skilllist/" + value ,function(data){
            var obj = $.parseJSON(data);
            console.debug(obj[0].itemValue)
            $("#selectionSkill").html("");
            for(var i=0;i<obj.length;i++){
                $("#selectionSkill").append("<option value="+obj[i].itemValue+">"+obj[i].itemLabel+"</option>");
            }
        })
    })
});

$(function() {
    $("#buttonSkillSearch").click(function() {

        $("#tableSkill").append(
        		$("<tr></tr>")
	                .append($("<td></td>").text("1"))
	                .append($("<td></td>").text("2"))
	                .append($("<td></td>").text("3"))
        		);

    /*

        var param1 = $("#selectionField").val();
        var param2 = $("#selectionSkill").val();
        var param3 = $("#inputEmployeeName").val();
        var data = {field: param1, skill: param2, name: param3 };
        $.ajax({
            type:"post",
            url:"http://localhost:8080/assign/skilltable",
            data:JSON.stringify(data),
            contentType: 'application/json',
            dataType: "json",
            success: function(json_data) {
              // 成功時の処理
            	alert("");
            }
        });


        $.post({
            "http://localhost:8080/assign/skilltable",
            {field : param1, skill : param2, name : param3 },
            function(data) {
                alert("ok");
                var obj = $.parseJSON(data);
                console.debug(obj[0].itemValue)
                $("#tableSkill").html("");
                for(var i=0;i<obj.length;i++){
                    $("#tableSkill").append(
                    		$("<tr></tr>")
    			                .append($("<td></td>").text(obj[i].itemName))
    			                .append($("<td></td>").text(obj[i].itemSkill))
    			                .append($("<td></td>").text(obj[i].itemExperience))
                    		);
                }

            }
        });
        */

    });

});
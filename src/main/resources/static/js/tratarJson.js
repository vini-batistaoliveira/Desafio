	//Jquery para pegar o valor de retorno do JSON e atribuir nos inputs do html
	$(document).ready(function() {
		$.ajax({
			method : "GET",
			url : "http://localhost:8080/funcionarios",
			dataType : "JSON"
		}).done(function(data) {
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				$('#id' + i).html(data[i].id);
				$('#nome' + i).html(data[i].nome);
				$('#cargo' + i).html(data[i].cargo);
				$('#salario' + i).html(data[i].salario);
				var skillZ = '';
				for (var z = 0; z < data[i].skill.length; z++) {
					if (z === data[i].skill.length - 1) {
						skillZ += data[i].skill[z].nome;
					} else {
						skillZ += data[i].skill[z].nome + ' - ';
					}
				}
				$('#skill' + i).html(skillZ);
			}

		}).fail(function(data) {
			console.log(data);
		});

		$('test').click(function() {
			console.log(this.value)
		});
	});

	// Função para pegar os valores selecionados no checkbox de filtro e verifica se funcionario possuie os skills selecionados
	$(document).ready(function() {
		$("#filtro").click(function() {
			$.ajax({
				method : "GET",
				url : "http://localhost:8080/funcionarios",
				dataType : "JSON"
			}).then(function(data) {
				var funcionario = [];
				////Pega valores input
				var skill = document.forms[0];
				var txt = [];
				var i;
				for (i = 0; i < skill.length; i++) {
					if (skill[i].checked) {
						txt.push(skill[i].value);
					}
				}
				
				for (var i = 0; i < data.length; i++) {			
					var skillFunc = [];
					var skillZ = '';
					for (var z = 0; z < data[i].skill.length; z++) {
						if (z === data[i].skill.length - 1) {
							skillFunc.push(data[i].skill[z].nome);
							//Compara os arrays de skill checkbox com skill dos funcionarios
							function arraysEqual(skillFunc,txt) {
							    if( JSON.stringify(skillFunc)==JSON.stringify(txt)){
							    		funcionario.push(data[i].nome);
							    }
							}
					} else {
						skillFunc.push(data[i].skill[z].nome);
					}
				} 
				//Chamada da function que compara os arrays de skill do filtro com skill dos funcionarios
				arraysEqual(skillFunc,txt);
				} 
				console.log("HELP ME GOD PLZ " + funcionario);
				if(typeof funcionario !== 'undefined' && funcionario.length > 0){
					alert("Os Funcionários com os skill's: " + txt + " são: " + funcionario);
				} else {
					alert("Nenhum funcionario com os skill's: " + txt + " foi encontrado!!!");
				}
			});
		});
	});

$(document).ready( function () {
	 var table = $('#myTable').DataTable({
			"sAjaxSource": "/funcionarios",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id"},
			    { "mData": "nome" },
			    { "mData": "salario" },
				{ "mData": "cargo" },
			    { "mData": "skill"}
			]
	 })
});

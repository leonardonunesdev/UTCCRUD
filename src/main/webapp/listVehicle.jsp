<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Mostra todos os veículos</title>
    </head>
    <body>
        <h1 class="text-center">Lista de veículos</h1>
        <div class="container-fluid">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Placa</th>
                        <th scope="col">Renavam</th>
                        <th scope="col">Proprietario</th>
                        <th scope="col">Condutor</th>
                        <th scope="col">Veículo</th>
                        <th scope="col">Ano</th>
                        <th scope="col">Quilometragem</th>
                        <th scope="col">Chassi</th>
                        <th scope="col">Situação</th>
                        <th scope="col">Lugares</th>
                        <th scope="col" colspan=2></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${vehicles}" var="vehicle">
                        <tr>
                            <td><c:out value="${vehicle.idVeiculo}" /></td>
                            <td><c:out value="${vehicle.descPlaca}" /></td>
                            <td><c:out value="${vehicle.descRenavam}" /></td>
                            <td><c:out value="${vehicle.descProprietario}" /></td>
                            <td><c:out value="${vehicle.descCondutor}" /></td>
                            <td><c:out value="${vehicle.descVeiculo}" /></td>
                            <td><c:out value="${vehicle.anoFabricacao}" /></td>
                            <td><c:out value="${vehicle.qtdKmAtual}" /></td>
                            <td><c:out value="${vehicle.descChassi}" /></td>
                            <td><c:out value="${vehicle.flagSituacao}" /></td>
                            <td><c:out value="${vehicle.qtdLugares}" /></td>
                            <td><a class="btn btn-primary btn-sm" role="button" href="VehicleController?action=edit&id_veiculo=<c:out value="${vehicle.idVeiculo}"/>">Atualizar</a></td>
                            <td><a class="btn btn-danger btn-sm" role="button" href="VehicleController?action=delete&id_veiculo=<c:out value="${vehicle.idVeiculo}"/>">Deletar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary" role="button" href="VehicleController?action=insert">Adicionar Veículo</a>
        </div>
    </body>
</html>
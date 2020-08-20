<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="JS/vehicle.js"></script>

        <title>Adiciona novo veículo</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="col-md-6">
                <form method="POST" action='VehicleController' name="formAddVehicle">
                    <div class="form-group col-md-6">
                        <label for="proprietarioControl">Proprietário</label>
                        <input size="100" value="<c:out value="${vehicle.descProprietario}" />" type="text" name="desc_proprietario" class="form-control" id="proprietarioControl">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="condutorControl">Condutor</label>
                        <input size="100" value="<c:out value="${vehicle.descCondutor}" />" type="text" name="desc_condutor" class="form-control" id="condutorControl">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="veiculoControl">Descrição Veículo</label>
                        <input size="100" value="<c:out value="${vehicle.descVeiculo}" />" type="text" name="desc_veiculo" class="form-control" id="veiculoControl">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="placaControl">Placa</label>
                        <input size="10" value="<c:out value="${vehicle.descPlaca}" />" type="text" name="desc_placa" class="form-control" id="placaControl">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="renavamControl">Renavam</label>
                        <input size="10" value="<c:out value="${vehicle.descRenavam}" />" type="text" name="desc_renavam" class="form-control" id="renavamControl">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="lugaresControl">Lugares</label>
                        <input size="2" value="<c:out value="${vehicle.qtdLugares}" />" type="number" name="qtd_lugares" class="form-control" id="lugaresControl">
                        <span></span>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="anoFabricacaoControl">Ano Fabricação</label>
                        <input size="4" value="<c:out value="${vehicle.anoFabricacao}" />" type="number" name="ano_fabricacao" class="form-control" id="anoFabricacaoControl">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="quilometragemAtualControl">Quilometragem Atual</label>
                        <input size="7" value="<c:out value="${vehicle.qtdKmAtual}" />" type="number" name="qtd_kmatual" class="form-control" id="quilometragemAtualControl">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="chassiAtualControl">Chassi</label>
                        <input size="17" value="<c:out value="${vehicle.descChassi}" />" type="text" name="desc_chassi" class="form-control" id="chassiAtualControl">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="situacaoControl">Situação</label>
                        <select name="flag_situacao" value="<c:out value="${vehicle.flagSituacao}" />" class="form-control" id="situacaoControl">
                            <option value="A">Ativo</option>
                            <option value="I">Inativo</option>
                        </select>
                    </div>
                    <div class="form-group col-md-12">
                        <div>
                            <input id="btnSubmit" class="btn btn-primary" type="submit" value="Enviar" />
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
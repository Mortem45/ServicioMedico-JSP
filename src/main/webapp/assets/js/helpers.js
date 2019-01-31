$(document).ready(function () {
    let menuLeft       = $('.ui.sidebar');
    //menu lado izquierdo
    $(".menuToggle").click(function () {
        menuLeft.sidebar('show');
    });
    
});

function sendData(url, form, button) {
    $(form + " " + button).on('click', function (e) {
        e.preventDefault();
        if ($(form)[0].checkValidity()) {
            let dataSend = {},
                    existData = false;

            $(form + " :input").each(function () {
                let input = $(this)[0];
                if (input.type !== 'submit' && input.type !== 'button') {
                    let name = input.name || input.id;
                    existData = true;
                    dataSend[name] = input.value;
                }
            });

            if (existData) {
                $("#screenMessage #legend").text("GUARDANDO...");
                $("#screenMessage").fadeIn();
                $.ajax({
                    method: "POST",
                    url: url,
                    data: dataSend,
                }).always(function (e) {
                    $("#screenMessage").fadeOut(function () {
                        window.location.reload();
                    });
                });
            }
        } else {
            $(form).children().last().before(
                    '<div class="ui red message">\n\
                            Este formulario tiene campos requeridos(*)\n\
                            <br>\n\
                            O el formato de algún campo no es válido\n\
                        </div>'
            );
            setTimeout(function () {
                $(form + " #notificationInvalidForm").remove();
            }, 3000);
        }
    });
}

function updateData(tag) {
    item = $(tag);
    let data = item.data();
    
    for (var id in data) {
        $("#" + id).val(data[id]);
    }
    
    $("html").animate({scrollTop: 0}, 500, function () {
        $("#btnSendData").text(" Actualizar");
    });
}

function cancelData(form, button) {
    $(form + " " + button).on('click', function (e) {
         e.preventDefault();

        $("#btnSendData").text(" Guardar");
        $(form + " :input").each(function () {
            let inputJquery = $(this),
            input = inputJquery[0];
            if (input.type !== 'submit' && input.type !== 'button' 
                && !inputJquery.is('[readonly]')) {
                inputJquery.val("");
            }
        });
    });
}

function deleteData(tag, identity, url) {
    item = $(tag);
    let data = item.data(),
    dataSend = {},
    existData = false;

    for (var id in data) {
        if (identity == id) {
            existData = true;
            dataSend[id] = data[id];
        } else {
            dataSend[id] = "";
        }
    }

    if (existData) {
        $("#screenMessage #legend").text("Eliminando...");
        $("#screenMessage").fadeIn();
        $.ajax({
            method: "POST",
            url: url,
            data: dataSend,
        }).always(function (e) {
            $("#screenMessage").fadeOut(function () {
                window.location.reload();
            });
        });
    }
}

function selects_direccion(form, url) {
    //departamentos id_municipio
    let tagPais = "#id_pais";
    let tagDepartamento = "#id_departamento"
    let tagMunicipio = "#id_municipio"
    let tagColonia = "#id_colonia"

    let  idPais = $(form + " " + tagPais).val();
    if (idPais != "" && idPais != null) {
        $("#screenMessage #legend").text("SELECT...");
        $("#screenMessage").fadeIn();
        $.ajax({
            url: url,
            data: {
                type: "departamento",
                id: idPais
            }
        }).always(function (e) {
            $(tagDepartamento).html(e);
            $("#screenMessage").fadeOut(function () {});
        });
    }

    $(form + " " + tagDepartamento).change(function () {
        let  idDepartamento = $(form + " " + tagDepartamento).val();
        if (idDepartamento != "" && idDepartamento != null) {
            $("#screenMessage #legend").text("SELECT...");
            $("#screenMessage").fadeIn();
            $.ajax({
                url: url,
                data: {
                    type: "municipio",
                    id: idDepartamento
                }
            }).always(function (e) {
                $(tagMunicipio).html(e);
                $("#screenMessage").fadeOut(function () {});
            });
        }
    });

    $(form + " " + tagMunicipio).change(function () {
        let  idMunicipio = $(form + " " + tagMunicipio).val();
        if (idMunicipio != "" && idMunicipio != null) {
            $("#screenMessage #legend").text("SELECT...");
            $("#screenMessage").fadeIn();
            $.ajax({
                url: url,
                data: {
                    type: "colonia",
                    id: idMunicipio
                }
            }).always(function (e) {
                $(tagColonia).html(e);
                $("#screenMessage").fadeOut(function () {});
            });
        }
    });
}
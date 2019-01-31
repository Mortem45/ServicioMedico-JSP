package com.dbsm.controllers;

/**
 *
 * @author Grupo5
 */
public class Helpers {
    public static String head(String rout) {
        String output = "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <meta charset='UTF-8'>"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "        <link rel=\"icon\" type=\"image/png\" href=\"" + rout + "/assets/img/icon.png\">\n"
                + "        <link rel=\"stylesheet\" href=\"" + rout + "/assets/semantic/semantic.min.css\">\n"
                + "        <link rel=\"stylesheet\" href=\"" + rout + "/assets/css/custom.css\">";
        return output;
    }
    
    public static String menu(String rout) {
        String output = "<div id=\"sidebar-menu\" class='ui sidebar inverted vertical menu'>\n"
                + "            <a class=\"item\"></a>\n"
                + "            <a class=\"item animated\" href='" + rout + "'>\n"
                + "                <i class=\"medkit icon\"></i>HOME\n"
                + "            </a>\n"
                + "            <a class=\"item\"></a>\n"
                + "            <a class=\"item\" href='" + rout + "/catalogo/index.jsp'>"
                + "                 <i class=\"tasks icon\" style'color: #ff851b;'></i>Catalogos"
                + "            </a>\n"
                + "            <a class=\"item\" href='" + rout + "/general/sedes.jsp'>"
                + "                 <i class=\"map marker alternate icon\" style'color: #ff851b;></i>Sedes"
                + "            </a>\n"
                + "            <a class=\"item\" >"
                + "                 <i class=\"home icon\"></i>Catalogos"
                + "            </a>\n"
                + "            <a class=\"item animated\" href=\"./closeSession.php\">\n"
                + "                <i class=\"sign-out icon\"></i>Logout\n"
                + "            </a>\n"
                + "        </div>\n"
                + "        <div class=\"pusher\">";
        return output;
    }
    
    public static String navBarTop(String rout) {
        String output = "<div class=\"nav-e\"></div>\n"
                + "            <div class=\"following bar light fixed\">\n"
                + "                <div class=\"ui attached stackable menu\">\n"
                + "                    <div class=\"ui container\">\n"
                + "                        <a class=\"item menuToggle text-white\">\n"
                + "                            <i class=\"th list icon\"></i>\n"
                + "                        </a>\n"
                + "                        <a class=\"cf-logo\" href='" + rout + "'>\n"
                + "                            <div class=\"nivel\">\n"
                + "                                <div class=\"content-s\">\n"
                + "                                    <div class=\"letter letter-s\">S</div>\n"
                + "                                </div>\n"
                + "                                <div class=\"letter letter-m\">M</div>\n"
                + "                            </div>\n"
                + "                            <div class=\"nivel\">\n"
                + "                                <span class=\"letter name\">Service</span>\n"
                + "                                <span class=\"letter name\">Medical</span>\n"
                + "                            </div>\n"
                + "                        </a>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>";
        return output;
    }
    
    public static String footerPage() {
        String output = "      <div class = \"loading\" id=\"screenMessage\">\n"
                + "                <div class = \"blob-1\"></div>\n"
                + "                <div class = \"blob-2\"></div>\n"
                + "                <p id=\"legend\">Loading...<p>\n"
                + "            </div>"
                + "            <div class=\"fw-footer\" style=\"\">\n"
                + "                <div class=\"skew\"></div>\n"
                + "                <div class=\"skew-bg\"></div>\n"
                + "                <div class=\"copyright\">\n"
                + "                    <h4>Servive Medical</h4>\n"
                + "                    <p>designed and created by Grupo 5 DB1.<br>\n"
                + "                        ©GRUPO 5 DB1\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>";
        return output;
    }
    
    public static String header(String rout) {
        String output =  "";
        return output;
    }

    public static String footerScript(String rout) {
        String output = ""
                + "            <script src=\"" + rout + "/assets/js/jquery_3_3_1.js\"></script>\n"
                + "            <script src=\"" + rout + "/assets/semantic/semantic.min.js\"></script>\n"
                + "            <script src=\"" + rout + "/assets/js/helpers.js\" charset='utf-8'></script>";
        return output;
    }
}

package data.dummy;

import data.REST.Constants;
import rest.API;

public class SupplierData implements data.SupplierData {
    @Override
    public String getSupplier(int supplierId) {

        return "{\"SupplierId\":69,\"SupName\":\"NEW CONCEPTS - CANADA\"}";
    }

    @Override
    public String getAllSuppliers() {

        return "[{\"SupplierId\":69,\"SupName\":\"NEW CONCEPTS - CANADA\"},{\"SupplierId\":80,\"SupName\":\"CHAT / TRAVELINE\"},{\"SupplierId\":100,\"SupName\":\"AVILA TOURS INC.\"},{\"SupplierId\":317,\"SupName\":\"BLYTH \\u0026 COMPANY TRAVEL\"},{\"SupplierId\":323,\"SupName\":\"COMPAGNIA ITALIANA TURISM\"},{\"SupplierId\":796,\"SupName\":\"CYPRUS AIRWAYS LTD\"},{\"SupplierId\":828,\"SupName\":\"DER TRAVEL SERVICE LTD\"},{\"SupplierId\":845,\"SupName\":\"DISCOVER THE WORLD MARKET\"},{\"SupplierId\":908,\"SupName\":\"ELITE ORIENT TOURS INC.\"},{\"SupplierId\":1005,\"SupName\":\"ENCORE CRUISES\"},{\"SupplierId\":1028,\"SupName\":\"EUROP-AUTO-VACANCES/HOLIDAYS\"},{\"SupplierId\":1040,\"SupName\":\"EXECUTIVE SUITES\"},{\"SupplierId\":1205,\"SupName\":\"GOLDMAN MARKETING\"},{\"SupplierId\":1406,\"SupName\":\"EUROCRUISES INC.\"},{\"SupplierId\":1416,\"SupName\":\"THE HOLIDAY NETWORK\"},{\"SupplierId\":1425,\"SupName\":\"HOLLAND AMERICA LINE WEST\"},{\"SupplierId\":1542,\"SupName\":\"INSIGHT VACATIONS CANADA\"},{\"SupplierId\":1620,\"SupName\":\"INTAIR VACATIONS\"},{\"SupplierId\":1634,\"SupName\":\"ISLANDS IN THE SUN CRUISE\"},{\"SupplierId\":1685,\"SupName\":\"GOWAY TRAVEL LTD.\"},{\"SupplierId\":1713,\"SupName\":\"JETPACIFIC HOLIDAYS INC\"},{\"SupplierId\":1766,\"SupName\":\"KLM ROYAL DUTCH AIRLINES\"},{\"SupplierId\":1859,\"SupName\":\"LOTUS HOLIDAYS\"},{\"SupplierId\":1918,\"SupName\":\"MARKET SQUARE TOURS\"},{\"SupplierId\":2140,\"SupName\":\"NAGEL TOURS LTD\"},{\"SupplierId\":2386,\"SupName\":\"PAVLIK TRAVEL GROUP\"},{\"SupplierId\":2466,\"SupName\":\"PLANET FRANCE/PLANET EURO\"},{\"SupplierId\":2588,\"SupName\":\"UNIQUE VACATIONS (CANADA)\"},{\"SupplierId\":2592,\"SupName\":\"ESPRIT/SERVICENTRE HOLIDAYS\"},{\"SupplierId\":2827,\"SupName\":\"SOUTH WIND TOURS LTD.\"},{\"SupplierId\":2938,\"SupName\":\"SUN \\u0026 LEISURE TRAVEL CORP.\"},{\"SupplierId\":2987,\"SupName\":\"TOURCAN VACATIONS INC\"},{\"SupplierId\":2998,\"SupName\":\"ALIOTOURS\"},{\"SupplierId\":3119,\"SupName\":\"MEDIAN AVIATION RESOURCES\"},{\"SupplierId\":3212,\"SupName\":\"TREK HOLIDAYS\"},{\"SupplierId\":3273,\"SupName\":\"MARKETING AHEAD\"},{\"SupplierId\":3376,\"SupName\":\"MARTINAIR SERVICES\"},{\"SupplierId\":3549,\"SupName\":\"BONANZA HOLIDAYS\"},{\"SupplierId\":3576,\"SupName\":\"BLUE DANUBE HOLIDAYS\"},{\"SupplierId\":3589,\"SupName\":\"G.A.P ADVENTURES INC.\"},{\"SupplierId\":3600,\"SupName\":\"GOLDEN ESCAPES\"},{\"SupplierId\":3622,\"SupName\":\"CHINA TRAVEL SERVICE (CAN)\"},{\"SupplierId\":3633,\"SupName\":\"VIP INTERNATIONAL\"},{\"SupplierId\":3650,\"SupName\":\"CUNARD LINES\"},{\"SupplierId\":4196,\"SupName\":\"TRAVEL STUDIO\"},{\"SupplierId\":5081,\"SupName\":\"ANHEUSER-BUSCH ADVENTURE\"},{\"SupplierId\":5228,\"SupName\":\"THE RMR GROUP INC\"},{\"SupplierId\":5492,\"SupName\":\"SKYWAYS INTERNATIONAL\"},{\"SupplierId\":5777,\"SupName\":\"TRAVEL BY RAIL\"},{\"SupplierId\":5796,\"SupName\":\"REPWORLD INC.\"},{\"SupplierId\":5827,\"SupName\":\"RESORT MARKETING INC\"},{\"SupplierId\":5857,\"SupName\":\"TOURS OF EXPLORATION\"},{\"SupplierId\":6346,\"SupName\":\"PASSAGES EXPEDITIONS\"},{\"SupplierId\":6505,\"SupName\":\"TRADE WINDS ASSOCIATES\"},{\"SupplierId\":6550,\"SupName\":\"LTI TOURS\"},{\"SupplierId\":6873,\"SupName\":\"BIMAN BANGLADESH AIRLINES\"},{\"SupplierId\":7244,\"SupName\":\"WORLD ACCESS MARKETING\"},{\"SupplierId\":7377,\"SupName\":\"MAJESTIC TOURS\"},{\"SupplierId\":8089,\"SupName\":\"EXCLUSIVE TOURS\"},{\"SupplierId\":8837,\"SupName\":\"SCANDITOURS\"},{\"SupplierId\":9285,\"SupName\":\"JTB INTERNATIONAL (CANADA)\"},{\"SupplierId\":9323,\"SupName\":\"BONAVE\"},{\"SupplierId\":9396,\"SupName\":\"SKYLINK TICKET CENTRE\"},{\"SupplierId\":9766,\"SupName\":\"KINTETSU INTERNATIONAL\"},{\"SupplierId\":9785,\"SupName\":\"MANDITOURS INTL INC.\"},{\"SupplierId\":11156,\"SupName\":\"ALITOURS INTERNATIONAL INC.\"},{\"SupplierId\":11160,\"SupName\":\"TOTAL ADVANTAGE TRAVEL\"},{\"SupplierId\":11163,\"SupName\":\"D-TOUR MARKETING\"},{\"SupplierId\":11172,\"SupName\":\"MERIT TRAVEL GROUP INC.\"},{\"SupplierId\":11174,\"SupName\":\"GRUPO TACA\"},{\"SupplierId\":11237,\"SupName\":\"DKM COACH LINES LTD\"},{\"SupplierId\":11549,\"SupName\":\"GO ACTIVE VACATIONS\"},{\"SupplierId\":12657,\"SupName\":\"SAAAI TRAVEL INC.\"},{\"SupplierId\":13596,\"SupName\":\"A \\u0026 TIC SUPPORT INC.\"}]";
    }

    @Override
    public String insertSupplier(String jsonData) {

        return "INSERT on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String updateSupplier(String jsonData) {

        return "UPDATE on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String deleteSupplier(int supplierId) {

        return "DELETE on " + supplierId + "\n...attemtped.\nMethod not yet implemented";
    }
}

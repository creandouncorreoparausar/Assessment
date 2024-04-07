/*import io.restassured.RestAssured;

public class bonusTask {
    /*public static void main(String[] args){
        //Step1: Add candidate thru web apis using rest assured
        RestAssured
                .given()
                .baseUri("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates")
                .when()
                .get()
                .prettyPrint();


    public static void addCandidate{
        //Step1: Add candidate thru web apis using rest assured
        RestAssured
                .given()
                .baseUri("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates")
                .header("Contect-Type", "application/json")
                .body("\"userName\": \"asmaadiyab\",\"deleted\": false,\"status\": true,\"employee\": {\"empNumber\": 104,\"employeeId\": \"0312\",\"firstName\": \"A8DCo\",\"middleName\": \"4Ys\",\"lastName\": \"010Z\",\"terminationId\": null},\"userRole\": {\"id\": 1,\"name\": \"Admin\",\"displayName\": \"Admin\"}")
                .when()
                .post()
                .prettyPrint()
                .statusCode(200)
                .log().body();;
    }
    public static void deleteCandidate{
        //Step2: delete candidate thru web apis using rest assured
        RestAssured
                .given()
                .baseUri("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates")
                .header("Contect-Type", "application/json")
                .body("\"userName\": \"asmaadiyab\",\"deleted\": false,\"status\": true,\"employee\": {\"empNumber\": 104,\"employeeId\": \"0312\",\"firstName\": \"A8DCo\",\"middleName\": \"4Ys\",\"lastName\": \"010Z\",\"terminationId\": null},\"userRole\": {\"id\": 1,\"name\": \"Admin\",\"displayName\": \"Admin\"}")
                .when()
                .delete()
                .prettyPrint();
    }
}
*/
package API.Tests;

import Specifications.Specifications;
import org.junit.Assert;
import org.junit.Test;
import API.PojoClasses.Item;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static API.Helpers.GenerateUniqueSerialNumber.*;
import static io.restassured.RestAssured.given;

public class InvTest {
    public final String url = "http://localhost:8082/";


    @Test
    public void addNewItem() {
        Specifications.installSpecs(Specifications.request(url), Specifications.responseOK200());
        for (int i = 0; i < 10; i++) {
            Item newItem = new Item(
                    "Chisinau",
                    randomCode("INV000000", 0, 3),
                    randomCode("ACC00000000", 0, 3),
                    "PC",
                    "Dell",
                    "Optiplex 3040",
                    uniqueSN(getRAndomInt(5, 15)),
                    "Office",
                    "PC-HOSTNAME1",
                    "10.20.30.40",
                    false,
                    "User Name",
                    "Quality",
                    "ON123456",
                    "Nane User"
            );
            System.out.println(newItem.getSerialnumber());
            Item createItem = given()
                    .body(newItem)
                    .when()
                    .post("api/items")
                    .then()
                    .extract().as(Item.class);
        }
    }

    @Test
    public void getAllItems() {
        Specifications.installSpecs(Specifications.request(url), Specifications.responseOK200());
        List<Item> items = given()
                .when()
                .get("api/items")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("", Item.class);
        if (items.size() == 0) {
            System.out.println("No items in DB yet");
        } else {
            System.out.println("There are " + items.size() + " items in DB");
        }
        List<String> serialNumbersList = items.stream().map(Item::getSerialnumber).collect(Collectors.toList());
        Set<String>  seralNumbersSet = new HashSet<>(serialNumbersList);
        Assert.assertEquals(seralNumbersSet.size(), serialNumbersList.size());
        System.out.println("There are no duplicates");
    }

    @Test
    public void deleteItem(){
        Specifications.installSpecs(Specifications.request(url), Specifications.responseOK200());

        given()
                .when()
                .delete("api/items/4")
                .then()
                .assertThat().statusCode(200);
    }
}

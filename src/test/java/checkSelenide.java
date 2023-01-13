import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class checkSelenide {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkExampleJUnit5Selenide() {
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("[id=wiki-tab]").click();
        //$$("[id=wiki-tab]")
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".js-wiki-more-pages-link").click();
        sleep(1000);
        $("[data-filterable-for=wiki-pages-filter]").$$(".Box-row.wiki-more-pages").last().shouldHave((text("SoftAssertions"))).click();
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("[id=wiki-body]").shouldHave((text("Using JUnit5 extend test class")));
    }
}

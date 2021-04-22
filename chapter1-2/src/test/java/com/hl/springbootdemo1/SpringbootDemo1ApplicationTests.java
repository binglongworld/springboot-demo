package com.hl.springbootdemo1;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootDemo1ApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Test
    public void generateMarkdownDocs() throws Exception {

        URL remoteSwaggerFile = new URL("http://localhost:8080/v2/api-docs");
        Path outputDirectory = Paths.get("src/docs/markdown/generated");

        //    输出Markdown格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .build();


        Swagger2MarkupConverter.from(remoteSwaggerFile)
                .withConfig(config)
                .build()
                .toFolder(outputDirectory);
    }

}

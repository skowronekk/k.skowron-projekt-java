package com.crud.tasks.trello.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    public TrelloConfig trelloConfig;

    @Test
    public void testTrelloConfig() {

        //Then
        Assert.assertEquals("kasia66834383", trelloConfig.getTrelloMember());
        Assert.assertEquals("https://api.trello.com/1", trelloConfig.getTrelloApiEndpoint());

    }
}

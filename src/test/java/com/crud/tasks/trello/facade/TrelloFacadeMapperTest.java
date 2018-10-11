package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrelloFacadeMapperTest {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {

        //Given
        TrelloListDto listDto1 = new TrelloListDto("1122", "test1", false);
        TrelloListDto listDto2 = new TrelloListDto("3344", "test2", true);
        List<TrelloListDto> listsDto1 = new ArrayList<>();
        List<TrelloListDto> listsDto2 = new ArrayList<>();
        listsDto1.add(listDto1);
        listsDto2.add(listDto2);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("Board1", "test DtoBoard1", listsDto1);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("Board2", "test DtoBoard2", listsDto2);
        List<TrelloBoardDto> testList = new ArrayList<>();
        testList.add(trelloBoardDto1);
        testList.add(trelloBoardDto2);
        //When
        List<TrelloBoard> testResult = trelloMapper.mapToBoards(testList);
        int numberOfBoards = testResult.size();
        String nameOfTestedBoard = testResult.get(1).getName();
        //Then
        Assert.assertEquals(2, numberOfBoards);
        Assert.assertEquals("test DtoBoard2", nameOfTestedBoard);
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList list1 = new TrelloList("4422", "test3", true);
        TrelloList list2 = new TrelloList("5544", "test4", false);
        List<TrelloList> lists1 = new ArrayList<>();
        List<TrelloList> lists2 = new ArrayList<>();
        lists1.add(list1);
        lists2.add(list2);
        TrelloBoard trelloBoard1 = new TrelloBoard("test Board3", "Board3", lists1);
        TrelloBoard trelloBoard2 = new TrelloBoard("test Board4", "Board4", lists2);
        List<TrelloBoard> testList = new ArrayList<>();
        testList.add(trelloBoard1);
        testList.add(trelloBoard2);
        //When
        List<TrelloBoardDto> testResult = trelloMapper.mapToBoardsDto(testList);
        int numberOfBoards = testResult.size();
        String nameOfTestedBoard = testResult.get(0).getName();
        //Then
        Assert.assertEquals(2, numberOfBoards);
        Assert.assertEquals("Board3", nameOfTestedBoard);

    }

    @Test
    public void testMapToCard() {

        //Given
        TrelloCardDto cardDto1 = new TrelloCardDto("card1", "testing", "test", "list1");

        //When
        TrelloCard testResult = trelloMapper.mapToCard(cardDto1);

        //Then
        Assert.assertEquals("list1", testResult.getListId());
        Assert.assertEquals("testing", testResult.getDescription());

    }
}

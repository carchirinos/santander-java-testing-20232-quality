package org.bedu.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.bedu.dto.InterviewerDTO;
import org.bedu.service.InterviewerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class InterviewerControllerTest {

  @MockBean
  private InterviewerService service;
  
  @Autowired
  private InterviewerController controller;

  @Test
  @DisplayName("Controller should be injected")
  public void smokeTest() {
    assertNotNull(controller);
  }

  @Test
  @DisplayName("Controller should return a list of interviewers")
  public void findAllTest() {
    // Arrange
    List<InterviewerDTO> fakeData = new LinkedList<>();

    InterviewerDTO fakeInterviewer = new InterviewerDTO();

    fakeInterviewer.setId(100);
    fakeInterviewer.setName("Joaquin Salazar");
    fakeInterviewer.setEmail("joaquin@test.com");

    fakeData.add(fakeInterviewer);

    // Simulando el resultado de ejecutar el método findAll()
    when(service.findAll()).thenReturn(fakeData);

    // Act
    List<InterviewerDTO> result = controller.findAll();

    // Assert
    assertEquals(fakeData, result);
  }
}
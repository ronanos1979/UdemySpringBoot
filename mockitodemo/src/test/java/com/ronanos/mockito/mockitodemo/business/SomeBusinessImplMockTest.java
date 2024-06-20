package com.ronanos.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

	@Mock
	DataService  dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl businessImpl;
	

	@Test
	void findTheGreatesFromAllData_basicScenarioWithAnnotations() {			
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,5});		
		assertEquals(25, businessImpl.findTheGreatedFromAllData());
	}
	
	@Test
	void findTheGreatesFromAllData_OneValueWithAnnotations() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatedFromAllData());
	}
	
	
	// This is the original way from here on down.
	@Test
	void findTheGreatesFromAllData_basicScenario() {
		DataService dataServiceMock = mock(DataService.class);		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,5});
 		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);		
		assertEquals(25, businessImpl.findTheGreatedFromAllData());
	}
	
	@Test
	void findTheGreatesFromAllData_OneValue() {
		DataService dataServiceMock = mock(DataService.class);		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
 		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);		
		assertEquals(35, businessImpl.findTheGreatedFromAllData());
	}
	
}


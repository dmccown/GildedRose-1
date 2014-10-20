import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void legendaryItemNeverChanges() throws Exception {
		Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(80, item.getQuality());
		assertEquals(0, item.getSellIn());
	}
	
	@Test
	public void normalItemQualityGoesDownByOne() throws Exception {
		Item item = new Item("+5 Dexterity Vest", 10, 20);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(19, item.getQuality());
		assertEquals(9, item.getSellIn());		
	}

	@Test
	public void normalItemQualityCantGoBelowZero() throws Exception {
		Item item = new Item("+5 Dexterity Vest", 10, 0);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(0, item.getQuality());
		assertEquals(9, item.getSellIn());		
	}
	
	@Test
	public void normalItemQualityGoesDownTwiceAsFastWhenExpired() throws Exception {
		Item item = new Item("+5 Dexterity Vest", 0, 10);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(8, item.getQuality());
		assertEquals(-1, item.getSellIn());		
	}
	
	@Test
	public void agedBrieQualityGoesUp() throws Exception {
		Item item = new Item("Aged Brie", 2, 0);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(1, item.getQuality());
		assertEquals(1, item.getSellIn());	
	}
	
	@Test
	public void agedBrieQualityCantGoOver50() throws Exception {
		Item item = new Item("Aged Brie", 2, 50);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(50, item.getQuality());
		assertEquals(1, item.getSellIn());	
	}
	
	@Test
	public void agedBrieQualityGoesUpTwiceAsFast() throws Exception {
		Item item = new Item("Aged Brie", 0, 10);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(12, item.getQuality());
		assertEquals(-1, item.getSellIn());	
	}
	
	@Test
	public void backstagePassesOver10DaysAway() throws Exception {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(21, item.getQuality());
		assertEquals(14, item.getSellIn());	
	}
	
	@Test
	public void backstagePassesWithin10Days() throws Exception {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(22, item.getQuality());
		assertEquals(9, item.getSellIn());	
	}
	
	@Test
	public void backstagePassesWithin5Days() throws Exception {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(23, item.getQuality());
		assertEquals(4, item.getSellIn());	
	}
	
	@Test
	public void backstagePassesAfterTheConcert() throws Exception {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(0, item.getQuality());
		assertEquals(-1, item.getSellIn());	
	}
	
	@Test
	public void backstagePassesOver10DaysAwayCantGoOver50() throws Exception {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(50, item.getQuality());
		assertEquals(14, item.getSellIn());	
	}
	
	@Test
	public void backstagePassesWithin10DaysCantGoOver50() throws Exception {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(50, item.getQuality());
		assertEquals(9, item.getSellIn());	
	}
	
	@Test
	public void backstagePassesWithin5DaysCantGoOver50() throws Exception {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
		
		GildedRose.updateQuality(Arrays.asList(item));
		
		assertEquals(50, item.getQuality());
		assertEquals(4, item.getSellIn());	
	}
}

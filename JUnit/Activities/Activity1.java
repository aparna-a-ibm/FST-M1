import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class Activity1 {
    public static ArrayList<String> list;

    @BeforeEach
    public void setUp(){
        list = new ArrayList<String>();
        list.add("alpha"); // at index 0
        list.add("beta"); // at index 1
    }

    @Test
    public void insertTest(){
        assertEquals(2,list.size(),"Size is not as expected.");
        //Adding a new value
        list.add("gamma");
        assertEquals(3,list.size(),"Size is not as expected.");
        assertEquals("alpha",list.get(0),"Expected element not found.");
        assertEquals("beta",list.get(1),"Expected element not found.");
        assertEquals("gamma",list.get(2),"Expected element not found.");

    }

    @Test
    public void replaceTest(){
        assertEquals(2,list.size(),"Size is not as expected.");
        list.add("sigma");
        assertEquals(3,list.size(),"Size is not as expected.");
        // Replace element in ArrayList
        list.set(1,"omega");
        assertEquals("alpha",list.get(0),"Expected element not found.");
        assertEquals("omega",list.get(1),"Expected element not found.");
        assertEquals("sigma",list.get(2),"Expected element not found.");
    }
}

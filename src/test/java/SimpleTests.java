import org.junit.Assert;
import org.junit.Test;

public class SimpleTests {
    @Test
    public void testNormalWeight()
    {
        var actualResult = getIMTResult( 160f, 47.65f);
        Assert.assertEquals("нормальная масса тела", actualResult);
    }

    @Test
    public void testNormal1Weight()
    {
        var actualResult = getIMTResult( 160f, 61.44f);
        Assert.assertEquals("нормальная масса тела", actualResult);
    }
    @Test
    public void testSmallWeight()
    {
        var actualResult = getIMTResult( 160f, 2f);
        Assert.assertEquals("выраженный дефицит массы тела", actualResult);
    }


    @Test
    public void testSmall2Weight()
    {
        var actualResult = getIMTResult( 160f, 41f);
        Assert.assertEquals("выраженный дефицит массы тела", actualResult);
    }

    @Test
    public void testLow1Weight()
    {
        var actualResult = getIMTResult( 160f, 43.52f);
        Assert.assertEquals("недостаточная масса тела", actualResult);
    }

    @Test
    public void testLow2Weight()
    {
        var actualResult = getIMTResult( 160f, 46.08f);
        Assert.assertEquals("недостаточная масса тела", actualResult);
    }

    @Test
    public void testBigWeight()
    {
        var actualResult = getIMTResult( 160f, 64f);
        Assert.assertEquals("избыточная масса тела", actualResult);
    }

    @Test
    public void testBig1Weight()
    {
        var actualResult = getIMTResult( 160f, 75f);
        Assert.assertEquals("избыточная масса тела", actualResult);
    }

    @Test
    public void testzeroHeight()
    {
        var actualResult = getIMTResult(0f, 76f);
        Assert.assertEquals("указан некорректный рост",actualResult);

    }
    @Test
    public void testoneHeight()
    {
        var actualResult = getIMTResult(-1f, 50f);
        Assert.assertEquals("указан некорректый рост",actualResult);
    }

    @Test
    public void testtwoHeight()
    {
        var actualResult = getIMTResult(28f, 50f);
        Assert.assertEquals("указан некорректый рост",actualResult);
    }

    @Test
    public void testthreeHeight()
    {
        var actualResult = getIMTResult(35f, 50f);
        Assert.assertEquals("указан некорректый рост",actualResult);
    }
    @Test
    public void testfwooHeight()
    {
        var actualResult = getIMTResult(36f, 50f);
        Assert.assertEquals("указан некорректый рост",actualResult);
    }

    @Test
    public void testzeroWeight()
    {
        var actualResult = getIMTResult(180f, 0f);
        Assert.assertEquals("указан некорректый вес",actualResult);
    }

    @Test
    public void testthouthWeight() {
        var actualResult = getIMTResult(180f, 1000f);
        Assert.assertEquals("указан некорректый вес", actualResult);
    }

    private String getIMTResult(Float heightCm, Float weightKg)
    {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;
        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19)  {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals(0.0f)) userResult+="указан некорректный рост";
        return userResult;
    }
}

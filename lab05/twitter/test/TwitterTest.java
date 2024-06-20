import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;

class TwitterTest {

    @Test
    void actual_call() {

        Twitter twitter = new Twitter();

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(true, actual);
    }

    @Test
    void mock_full_object() {

        Twitter twitter = createMock("twitter", Twitter.class);

        expect(twitter.loadTweet()).andReturn("hello @me");
        expect(twitter.loadTweet()).andReturn("hello @you");
        replay(twitter);

        String actual;

        actual = twitter.loadTweet();
        assertEquals("hello @me", actual);

        actual = twitter.loadTweet();
        assertEquals("hello @you", actual);
    }

    @Test
    void mock_partial_object() {

        Twitter twitter = partialMockBuilder(Twitter.class)
          .addMockedMethod("loadTweet")
          .createMock();

        expect(twitter.loadTweet()).andReturn("hello @me").times(2);
        replay(twitter);

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(true, actual);

        actual = twitter.isMentionned("you");
        assertEquals(false, actual);
    }

    @Test
    void isMentionned_lookForAtSymbol() {
        Twitter twitterMock = EasyMock.createMock(Twitter.class);
        EasyMock.expect(twitterMock.isMentionned("me")).andReturn(true);
        EasyMock.expect(twitterMock.isMentionned("you")).andReturn(false);
        EasyMock.replay(twitterMock);
        
        assert twitterMock.isMentionned("me");
        assert !twitterMock.isMentionned("you");
        
        EasyMock.verify(twitterMock);
    }

    @Test
    void isMentionned_dontReturnSubstringMatches() {
        Twitter twitterMock = EasyMock.createMock(Twitter.class);
        EasyMock.expect(twitterMock.isMentionned("me")).andReturn(false);
        EasyMock.expect(twitterMock.isMentionned("meat")).andReturn(true);
        EasyMock.replay(twitterMock);
        
        assert !twitterMock.isMentionned("me");
        assert twitterMock.isMentionned("meat");
        
        EasyMock.verify(twitterMock);
    }

    @Test
    void isMentionned_superStringNotFound() {
        Twitter twitterMock = EasyMock.createMock(Twitter.class);
        EasyMock.expect(twitterMock.isMentionned("me")).andReturn(true);
        EasyMock.expect(twitterMock.isMentionned("meat")).andReturn(false);
        EasyMock.replay(twitterMock);
        
        assert twitterMock.isMentionned("me");
        assert !twitterMock.isMentionned("meat");
        
        EasyMock.verify(twitterMock);
    }

    @Test
    void isMentionned_handleNull() {
        Twitter twitterMock = EasyMock.createMock(Twitter.class);
        EasyMock.expect(twitterMock.isMentionned("me")).andReturn(false);
        EasyMock.expect(twitterMock.isMentionned("meat")).andReturn(false);
        EasyMock.replay(twitterMock);
        
        assert !twitterMock.isMentionned("me");
        assert !twitterMock.isMentionned("meat");
        
        EasyMock.verify(twitterMock);
    }
}
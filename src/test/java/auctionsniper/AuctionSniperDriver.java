package auctionsniper;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.fixture.FrameFixture;

import java.awt.*;

import static org.assertj.swing.finder.WindowFinder.findFrame;

public class AuctionSniperDriver {
    private final FrameFixture frame;

    public AuctionSniperDriver(int timeoutMillis) {
        frame = findFrame(new GenericTypeMatcher<Frame>(Frame.class) {
            @Override
            protected boolean isMatching(Frame frame) {
                return frame.getTitle().equals(Main.MAIN_WINDOW_NAME) && frame.isShowing();
            }
        })
            .withTimeout(timeoutMillis)
            .using(BasicRobot.robotWithCurrentAwtHierarchy());
    }

    public void showsSniperStatus(String statusText) {
        frame.label().requireText(statusText);
    }
}

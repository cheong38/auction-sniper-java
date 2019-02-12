package auctionsniper;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.FrameFixture;

import java.awt.*;

import static auctionsniper.Main.MainWindow;
import static org.assertj.swing.finder.WindowFinder.findFrame;

public class AuctionSniperDriver {
    private final FrameFixture window;
    private final Robot robot = BasicRobot.robotWithCurrentAwtHierarchy();

    public AuctionSniperDriver(int timeoutMillis) {
        window = findFrame(new GenericTypeMatcher<Frame>(Frame.class) {
            @Override
            protected boolean isMatching(Frame frame) {
                return frame.getTitle().equals(MainWindow.MAIN_WINDOW_NAME) && frame.isShowing();
            }
        })
            .withTimeout(timeoutMillis)
            .using(robot);
    }

    public void showsSniperStatus(String statusText) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.label().requireText(statusText);
    }

    public void dispose() {
        robot.cleanUp();
    }
}

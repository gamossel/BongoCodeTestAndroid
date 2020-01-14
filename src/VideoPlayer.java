import java.util.ArrayList;
import java.util.List;

/*
 *  Used Observer design pattern for getting video segments.
 *  Play: As VideoPlayer is subscribed to VideoDownloader. When a segment is downloaded,
 *  VideoDownloader notifies VideoPlayer and that segment is played. Otherwise after timeout buffering indicator
 *  will be shown
 *  
 *  Forward: When user tap forward, it forwards to next tenth frame.
 *  
 *  Rewind: When user tap rewind, it starts with first frame.
 */

public class VideoPlayer extends Thread implements OnVideoSegmentReceivedListener  {
	private List<VideoSegment> videoSegmentList = new ArrayList<>();
	public static void main(String[] args) {
		VideoPlayer videoPlayer = new VideoPlayer();
		VideoDownloader videoDownloader = new VideoDownloader();
		videoDownloader.subscribe(videoPlayer);
		videoPlayer.play();
	}

	private void showBufferingIndicator() {
		System.out.println("Showing buffering indicator");
	}
	
	private boolean playVideoSegment() {
		System.out.println("Playing video......");
		return true;
	}
	
	private boolean playVideoSegmentToSpecificPosition(int offset) {
		synchronized (this) {
			notify();
			System.out.println("Played to position " + offset);
		}
		return true;
	}
	
	public boolean play() {
		try {
			synchronized (this) {
				wait(5000);
				showBufferingIndicator();
				return playVideoSegment();
			}
		} catch (InterruptedException e) {
			return playVideoSegment();
		}
	}
	
	public boolean forward(int position) {
		return playVideoSegmentToSpecificPosition(position);
	}
	
	public boolean rewind() {
		return playVideoSegmentToSpecificPosition(0);
	}

	@Override
	public void notifyVideoPlayer(VideoSegment videoSegment) {
		videoSegmentList.add(videoSegment);
		interrupt();
	}
}

class VideoSegment {
	byte []payload;
	boolean isLastSegment;
}

class VideoDownloader {
	private OnVideoSegmentReceivedListener onVideoSegmentReceivedListener; 
	
	public VideoDownloader() {
	}
	
	public void download() {
		// download asynchronously
		boolean shouldDownloadVideo = true;
		while (shouldDownloadVideo) {
			// Downloading and creating video segment
			VideoSegment videoSegment = new VideoSegment(); 
			shouldDownloadVideo = !videoSegment.isLastSegment;
			onVideoSegmentReceivedListener.notifyVideoPlayer(videoSegment);
		}
	}
	
	public void subscribe(VideoPlayer videoPlayer) {
		if (videoPlayer instanceof OnVideoSegmentReceivedListener) {
			onVideoSegmentReceivedListener = (OnVideoSegmentReceivedListener) videoPlayer;
		} else {
			throw new ClassCastException("VideoPlayer should implement OnVideoSegmentReceivedListener.");
		}
	}
	
}


interface OnVideoSegmentReceivedListener {
	void notifyVideoPlayer(VideoSegment videoSegment);
}
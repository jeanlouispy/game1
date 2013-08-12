import sdljava.SDLException;
import sdljava.SDLMain;
import sdljava.video.SDLSurface;
import sdljava.video.SDLVideo;


public class Installation {

	private SDLSurface screen = null;
	
	public Installation() throws SDLException, InterruptedException{
		
		//Initialize the SDL (only Video mode)
		SDLMain.init(SDLMain.SDL_INIT_VIDEO);
		
		screen = SDLVideo.setVideoMode(640, 480, 32, SDLVideo.SDL_DOUBLEBUF | SDLVideo.SDL_HWSURFACE);
		
		SDLVideo.wmSetCaption("Ma première fenêtre avac sdlJava", null);
		
		Thread.sleep(1000);
		screen.freeSurface();
		
		//Closing the SDL
		SDLMain.quit();
		
	}
	
	
	
	
}

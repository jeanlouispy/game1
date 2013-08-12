import sdljava.SDLException;
import sdljava.SDLMain;
import sdljava.video.SDLRect;
import sdljava.video.SDLSurface;
import sdljava.video.SDLVideo;
import sdljava.event.SDLEvent;
import sdljava.image.SDLImage;



public class main {

	public static void main(String[] args) throws SDLException, InterruptedException {
		
		SDLEvent event = null;
		boolean boucle = true;
		
		
		//Initialize the SDL (Video only)
		SDLMain.init(SDLMain.SDL_INIT_VIDEO);
		
		//Creating a new surface
		SDLSurface 	screen 		= null,
					rectangle	= null,
					background	= null,
					image 		= null;
		
		//Creating a new SDLRect
		SDLRect posRectangle 	= new SDLRect(150,150),
				posImage 		= new SDLRect(0,445),
				posImg_1 		= new SDLRect(50,0,50,50);
		
		//Save the SDLSurface retrieve by setVideoMode into screen
		screen = SDLVideo.setVideoMode(800, 600, 32, SDLVideo.SDL_HWSURFACE | SDLVideo.SDL_DOUBLEBUF);
		SDLVideo.wmSetCaption("Juanito's Adventure", null);
		
		//Changing color of the main screen
		//long couleur = screen.mapRGB(0, 0, 255);
		//screen.fillRect(couleur);
				
		
		//Adding a surface into the main surface
//		rectangle = SDLVideo.createRGBSurface(SDLVideo.SDL_HWSURFACE, 200, 150, 32, 0, 0, 0, 0);
//		rectangle.fillRect(rectangle.mapRGB(255, 0, 0));
//		rectangle.blitSurface(screen,posRectangle);
		
		
		
		
		//Adding a new surface from an image
		background = SDLImage.load("images/b.jpg");
		image = SDLImage.load("images/p.jpg");
		
		//initialize the hiden color
		image.setColorKey(SDLVideo.SDL_SRCCOLORKEY, image.mapRGB(191, 255, 255));
		image.setAlpha(SDLVideo.SDL_SRCALPHA, 90);
		
		while(boucle){
			
			event = SDLEvent.waitEvent();
			
			if(event.getType() == SDLEvent.SDL_QUIT)
				boucle = false;
				
			background.blitSurface(screen);
			image.blitSurface(screen,posImage);
			screen.flip();
			
		}
		
		//freeing memory
		//screen.freeSurface().
		
		//Closing the SDL
		SDLMain.quit();
						
	}

}

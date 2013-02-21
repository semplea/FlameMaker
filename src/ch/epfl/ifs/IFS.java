package ch.epfl.ifs;
import java.util.ArrayList;
import java.util.List;
import ch.epfl.flamemaker.geometry2d.*;

final class IFS {
	private final ArrayList<AffineTransformation> transformations = new ArrayList<AffineTransformation>();
	
	public IFS(ArrayList<AffineTransformation> transformations){
		for(AffineTransformation t : transformations) {
		    this.transformations.add(t.clone());
		}
	}
	
	public IFSAccumulator compute(Rectangle frame, int width, int height, int density){
	}
	
	
}

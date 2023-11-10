package polymorphism;

//* 다중상속 
public class TVCR extends Tv implements IVCR { //case 2. 인터페이스를 만들어 구현하던가 
	
	//case 1. 참조변수를 넣든가 
	VCR vcr = new VCR();

	@Override
	public void play() {
		vcr.play();
	}

	@Override
	public void stop() {
		vcr.stop();
	}

	@Override
	public void reset() {
		vcr.reset();
	}

	@Override
	public int getCounter() {
		return vcr.getCounter();
	}

	@Override
	public void setCounter(int c) {
		vcr.setCounter(c);
	}

}

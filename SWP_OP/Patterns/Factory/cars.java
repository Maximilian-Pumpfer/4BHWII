public interface cars {

    public String getName();

}


class Audi implements cars {

	@Override
	public String getName() {
		return "Audi";
    }

}

class Bmw implements cars {

	@Override
	public String getName() {
		return "BMW";
    }

}

class Vw implements cars {

	@Override
	public String getName() {
		return "VW";
	}

}

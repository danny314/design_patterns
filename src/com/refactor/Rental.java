package com.refactor;

class Rental {
    private Movie _movie = new Movie("movie_title", Movie.REGULAR);
	private int _daysRented;
	
    public Rental(Movie movie, DateRange range) {
        _movie = movie;
        _daysRented = (int)((range.getEnd().getTime() - range.getStart().getTime()) / (1000 * 60 * 60 * 24));
    }
    public int getDaysRented() {
        return _daysRented;
    }

    public String getTitle() {
        return _movie.getTitle();
    }
    
    public int getPriceCode() {
        return _movie.getPriceCode();
    }
	double getCharge() {
		return _movie.getCharge(_daysRented);
	}
	
	int getFrequentRenterPoints() {
		return _movie.getFrequentRenterPoints(_daysRented);
	}
	public Movie getMovie() {
		return _movie;
	}
}

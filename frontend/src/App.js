import "./App.css";
import api from "./api/axiosConfig";
import { useState, useEffect } from "react";
import Layout from "./components/Layout";
import { Routes, Route } from "react-router-dom";
import Home from "./components/home/Home";
import Header from "./components/header/Header";
import Trailer from "./components/trailer/Trailer";
import Reviews from "./components/reviews/Reviews";
import NotFound from "./components/notFound/NotFound";
import Login from "./components/login/Login";
import Signup from "./components/signup/Signup";
import MovieDetail from "./Pages/movieDetail/MovieDetail";
import Trending from "./components/trending/Trending";
import UserProfile from "./components/Profile/UserProfile";

function App() {
  const [movies, setMovies] = useState();
  const [movie, setMovie] = useState();
  const [reviews, setReviews] = useState([]);

  const getMovies = async () => {
    try {
      const response = await api.get("/api/v1/movies");

      setMovies(response.data);
      // console.log(response.data);
    } catch (err) {
      console.log(err);
    }
  };

  const getMovieData = async (movieId) => {
    try {
      const response = await api.get(`/api/v1/movies/${movieId}`);

      const singleMovie = response.data;
      // console.log(singleMovie)

      setMovie(singleMovie);

      setReviews(singleMovie.reviewIds);
      // console.log(singleMovie)
    } catch (error) {
      console.error(error);
    }
  };

  

  useEffect(() => {
    getMovies();
  }, []);

  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home movies={movies} />}></Route>
          <Route path="/Trailer/:ytTrailerId" element={<Trailer />}></Route>
          <Route
            path="/Reviews/:movieId"
            element={
              <Reviews
                getMovieData={getMovieData}
                movie={movie}
                reviews={reviews}
                setReviews={setReviews}
              />
            }
          ></Route>
          <Route path="*" element={<NotFound />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/trending" element={<Trending />}></Route>
          <Route path="/signup" element={<Signup />}></Route>
          <Route path="/movie/:id" element={<MovieDetail />}></Route>
          <Route path="/profile/:email" element={<UserProfile />}></Route>
          
        </Route>
      </Routes>
    </div>
  );
}

export default App;

import { ReactComponent as StarFull } from "assets/img/star-full.svg";
import { ReactComponent as StarHalf } from "assets/img/star-half.svg";
import { ReactComponent as StarEmpty } from "assets/img/star-empty.svg";
import "./styles.css";
import MovieStars from 'components/MovieStars';

type Props = {
  score: number;
  count: number;
}

function MovieScore({score, count }: Props) {
  
  return (
    <div className="dsmovie-score-container">
      <p className="dsmovie-score-value">
        {score > 0 ? score.toFixed(1) : "-"}
      </p>
      <MovieStars score={score} />
      <p className="dsmovie-score-count">{count} avaliações</p>
    </div>
  );
}

export default MovieScore;

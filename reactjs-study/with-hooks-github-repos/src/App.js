import React, {useState, useEffect} from 'react';
import Geolocation from './Geolocation';

export default function App() {
  const [repositories, setRepositories] = useState([]);

  useEffect(async () => {
    const response = await fetch("https://api.github.com/users/jclaudiocf/repos");
    const data = await response.json();

    setRepositories(data);
  }, []);

  useEffect(() => {
    const filtered = repositories.filter(repo => repo.favorite);

    document.title = `You have ${filtered.length} favorites`;
  }, [repositories])

  function handleFavorite(id) {
    const newRepositories = repositories.map(repo => {
      return repo.id === id ? {...repo, favorite: !repo.favorite} : repo;
    });

    setRepositories(newRepositories);
  }

  return (
    <>
    <ul>
      {repositories.map(repo => (
        <li key={repo.id}>
          <span>{repo.name} </span>
          {repo.favorite && <span> (favorite) </span>}
          <button onClick={() => handleFavorite(repo.id)}>Favorite</button>
          </li>
      ))}
    </ul>

    <Geolocation></Geolocation>
    </>
  );
}
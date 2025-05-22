function getMovieTitle(movies, projection) {
    const movie = movies.data.find(m=>m.movieId === projection.movieId)
    if (movie == null) {
        return projection.movieId
    }
    return movie.title
}

function formatDate(iso) {
    if (iso == null) return 'N/A'
    return new Date(iso).toLocaleString('sr-RS', {
        year: '2-digit',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit'
    })
}
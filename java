<script>
  const username = "Aasif1478"; // Your GitHub username

  fetch(`https://api.github.com/users/${username}/repos?sort=updated`)
    .then(response => response.json())
    .then(repos => {
      const container = document.getElementById('github-projects');
      container.innerHTML = ''; // Clear "Loading..."

      if (repos.length === 0) {
        container.innerHTML = "No repositories found!";
      } else {
        repos.forEach(repo => {
          if (!repo.fork) {
            const card = document.createElement('div');
            card.style.marginBottom = '15px';

            card.innerHTML = `
              <h3><a href="${repo.html_url}" target="_blank">${repo.name}</a></h3>
              <p>${repo.description || 'No description provided.'}</p>
              <p><strong>Language:</strong> ${repo.language || 'N/A'}</p>
            `;
            container.appendChild(card);
          }
        });
      }
    })
    .catch(error => {
      console.error('Error fetching GitHub repos:', error);
      document.getElementById('github-projects').innerText = "Failed to load projects.";
    });
</script>

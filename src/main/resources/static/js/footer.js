// src/main/resources/static/js/footer.js

export function createFooter() {
    const footer = document.getElementById('footer');
    if (footer) {
        footer.innerHTML = `
            <footer>
                <p>&copy; 2024 My Website. All rights reserved.</p>
            </footer>
        `;
    }
}

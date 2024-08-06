// src/main/resources/static/js/navbar.js

export function createNavbar() {
    const navbar = document.getElementById('navbar');
    if (navbar) {
        navbar.innerHTML = `
            <nav>
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/about">About</a></li>
                    <li><a href="/contact">Contact</a></li>
                </ul>
            </nav>
        `;
    }
}

function applyTheme(theme) {
  const body = document.body;
  const toggleBtn = document.getElementById("theme-toggle");

  if (theme === "light") {
    body.classList.add("light-theme");
  } else {
    body.classList.remove("light-theme");
  }

  if (toggleBtn) {
    if (theme === "light") {
      toggleBtn.textContent = "🌙 Mode sombre";
    } else {
      toggleBtn.textContent = "☀️ Mode clair";
    }
  }
}

document.addEventListener("DOMContentLoaded", () => {
  const stored = localStorage.getItem("theme") || "dark";
  applyTheme(stored);

  const toggleBtn = document.getElementById("theme-toggle");
  if (toggleBtn) {
    toggleBtn.addEventListener("click", () => {
      const current = document.body.classList.contains("light-theme")
        ? "light"
        : "dark";
      const next = current === "light" ? "dark" : "light";
      localStorage.setItem("theme", next);
      applyTheme(next);
    });
  }
});

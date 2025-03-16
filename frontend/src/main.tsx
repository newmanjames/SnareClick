import { createRoot } from 'react-dom/client'
import { BrowserRouter, Routes, Route } from "react-router"
import { ThemeProvider } from "@/components/theme-provider"
import './App.css'
import Home from './pages/Home.tsx'
import Track from './pages/Track.tsx'

createRoot(document.getElementById('root')!).render(
  <ThemeProvider defaultTheme="system" storageKey="theme">
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/track" element={<Track />} />
      </Routes>
    </BrowserRouter>
  </ThemeProvider>
)

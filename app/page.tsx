"use client"

import Link from "next/link"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Mail, Lock, Eye, EyeOff } from "lucide-react"
import { useState } from "react"

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-center bg-gray-50">
      <div className="w-full max-w-md">
        <LoginForm />
      </div>
    </main>
  )
}

function LoginForm() {
  const [passwordVisible, setPasswordVisible] = useState(false)

  return (
    <div className="flex flex-col space-y-6">
      {/* Header */}
      <div className="relative h-48 w-full overflow-hidden rounded-t-xl bg-blue-600">
        <div className="absolute bottom-0 left-0 p-6 text-white">
          <h2 className="text-xl font-medium">Tren</h2>
          <h1 className="text-2xl font-bold">Interurbano</h1>
        </div>
      </div>

      {/* Login Card */}
      <Card className="border-none shadow-lg">
        <CardHeader className="pb-2">
          <CardTitle className="text-center text-blue-600">Iniciar Sesión</CardTitle>
        </CardHeader>
        <CardContent>
          <form className="space-y-4">
            <div className="space-y-2">
              <Label htmlFor="email">Correo Electrónico</Label>
              <div className="relative">
                <Mail className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                <Input id="email" type="email" placeholder="correo@ejemplo.com" className="pl-10" />
              </div>
            </div>

            <div className="space-y-2">
              <Label htmlFor="password">Contraseña</Label>
              <div className="relative">
                <Lock className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                <Input
                  id="password"
                  type={passwordVisible ? "text" : "password"}
                  placeholder="••••••••"
                  className="pl-10"
                />
                <button
                  type="button"
                  className="absolute right-3 top-3 text-gray-500"
                  onClick={() => setPasswordVisible(!passwordVisible)}
                >
                  {passwordVisible ? <EyeOff className="h-4 w-4" /> : <Eye className="h-4 w-4" />}
                </button>
              </div>
            </div>

            <Button type="submit" className="w-full">
              Iniciar Sesión
            </Button>

            <div className="text-center text-sm">
              <Link href="/register" className="text-blue-600 hover:underline">
                ¿No tienes cuenta? Regístrate
              </Link>
            </div>
          </form>
        </CardContent>
      </Card>
    </div>
  )
}


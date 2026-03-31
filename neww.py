import google.generativeai as genai

genai.configure(api_key="AIzaSyC50UFs60cXUxjz1qAGemJvtRLfwfeFwTY")

model = genai.GenerativeModel("gemini-2.5-flash")

response = model.generate_content("bro mai api test kar rha hu tera but gemini api usege par maine abhi use kiya once time show hi nhi kar rha aisha kyo")

print(response.text)
# base image
FROM node:10.16.0-alpine AS build-step
# set working directory
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build
FROM nginx:1.16.1-alpine
COPY --from=build-step /app/dist/* /usr/share/nginx/html/
EXPOSE 80
CMD ["nginx","-g","daemon off;"]

